package com.example.teste_api.controllers;

import com.example.teste_api.dtos.UserDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid UserDto userDto){
        var usernamePassword = new UsernamePasswordAuthenticationToken(userDto.email(),userDto.pasword());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.ok().build();
    }


}
