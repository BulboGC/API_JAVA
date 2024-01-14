package com.example.teste_api.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuxService {


    private final PasswordEncoder encoder = new BCryptPasswordEncoder();

    public String passwordEncoder(String password){
        return  encoder.encode(password);
    }

    public boolean matchEncoder(String password, String encodedpassword){
       return encoder.matches(password,encodedpassword);
    }



}
