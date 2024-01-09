package com.example.teste_api.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuxService {

    public String passwordEncoder(String password){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return  encoder.encode(password);
    }

}
