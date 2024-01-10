package com.example.teste_api.controllers;

import com.example.teste_api.dtos.CompanyDto;
import com.example.teste_api.models.CompanyModel;
import com.example.teste_api.repositories.CompanyRepository;
import com.example.teste_api.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/signin")
    ResponseEntity<CompanyModel> signin (@RequestBody @Valid CompanyDto companyDto){
        //criar um usuario usando Companydto.[nome da vairavel] e criar um company tem que ser feito dentro de company service para usar o transaction
    }







}
