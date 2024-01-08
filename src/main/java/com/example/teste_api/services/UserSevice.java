package com.example.teste_api.services;

import com.example.teste_api.dtos.UserDto;
import com.example.teste_api.models.UserModel;
import com.example.teste_api.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserSevice {

    public String passwordEncoder(String password){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return  encoder.encode(password);
    }
    @Autowired
    private UserRepository userRepository;

    UserModel addUser(UserDto userDto){
       try{

           var userModel =  new UserModel();
           BeanUtils.copyProperties(userDto,userModel);
           UserModel existingUser = userRepository.findByEmail(userModel.getEmail());

           if(existingUser.getEmail() == null || existingUser.getEmail().isEmpty() ){
               throw  new Error("o email informado já existe no sistema, por favor informe um email válido ou faça o login");
           }

           userModel.setPassword(passwordEncoder(userModel.getPassword()));

           return userRepository.save(userModel);
       }catch (Exception e){
           throw new Error("Erro interno:", e);
       }

    }

}
