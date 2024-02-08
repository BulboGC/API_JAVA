package com.example.teste_api.services;

import com.example.teste_api.dtos.UserDto;
import com.example.teste_api.enums.UserRoleEnums;
import com.example.teste_api.models.CompanyModel;
import com.example.teste_api.models.UserModel;
import com.example.teste_api.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserSevice {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuxService auxService;

    @PersistenceContext
    private EntityManager entityManager;


    public UserModel findUser(String email){
       return userRepository.findByEmail(email);
    }


    public UserModel findUserById(UUID uuid){
       Optional<UserModel> user = userRepository.findById(uuid);
       if(user.isEmpty()){
           throw new Error("usuario nao encontrado");
       }
       return user.get();
    }

    public UserModel addUserEmployee(UserDto userDto){
       try{

           var userModel =  new UserModel();
           BeanUtils.copyProperties(userDto,userModel);
           userModel.setRole(UserRoleEnums.EMPLOYEE);
           UserModel existingUser = userRepository.findByEmail(userModel.getEmail());

           if(existingUser.getEmail() == null || existingUser.getEmail().isEmpty() ){
               throw  new Error("o email informado já existe no sistema, por favor informe um email válido ou faça o login");
           }

           //Encryptando a senha
           userModel.setPassword(auxService.passwordEncoder(userModel.getPassword()));

           return userRepository.save(userModel);
       }catch (Exception e){
           throw new Error("Erro interno:", e);
       }

    }

    public List<UserModel> getAllUsers(UUID companyId){
    return  userRepository.findByCompanyUuid(companyId);
    }

    public void deleteUser(UUID userId){
        userRepository.deleteById(userId);
    }

    public UserModel updateUser(UUID uuid,UserDto userDto){
        Optional<UserModel> user = userRepository.findById(uuid);
        if(user.isEmpty()){
            throw new Error("o id so usuário informado é inválido");
        }
        UserModel user0 = user.get();
        BeanUtils.copyProperties(userDto,user0);
        return userRepository.save(user0);
    }


    public UserModel updateRole(UUID uuid ,UserRoleEnums role){
        Optional<UserModel>  user0 = userRepository.findById(uuid);
        if(user0.isEmpty()){
            throw new Error("o id so usuário informado é inválido");
        }

        UserModel user = user0.get();
        user.setRole(role);
        userRepository.save(user);
        return user;
    }




}
