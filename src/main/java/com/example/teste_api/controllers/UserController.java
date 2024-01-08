package com.example.teste_api.controllers;

import com.example.teste_api.dtos.UserDto;
import com.example.teste_api.models.ProductModel;
import com.example.teste_api.models.UserModel;
import com.example.teste_api.repositories.UserRepository;
import com.example.teste_api.services.UserSevice;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/user")
    public ResponseEntity<List<UserModel>>  getProduct(){
        List<UserModel> user0 = userRepository.findAll();
        return ResponseEntity.status(HttpStatus.FOUND).body(user0);
    }

    @PostMapping("/user")
    public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserDto userDto){
        var userModel = new UserModel();
        BeanUtils.copyProperties(userDto,userModel);
        UserModel saveUser = userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);

    }

}
