package com.example.teste_api.controllers;

import com.example.teste_api.dtos.CompanyDto;
import com.example.teste_api.models.CompanyModel;
import com.example.teste_api.models.GarotoModel;
import com.example.teste_api.models.UserModel;
import com.example.teste_api.repositories.CompanyRepository;
import com.example.teste_api.repositories.UserRepository;
import com.example.teste_api.services.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    CompanyService companyService;



    @PostMapping("/resgister")
    ResponseEntity<?> signin (@RequestBody @Valid  CompanyDto companyDto){
            return ResponseEntity.status(HttpStatus.CREATED).body(companyService.createCompany(companyDto));
    }


    @PostMapping("/garoto")
    ResponseEntity<?> fazoL(@RequestBody @Valid  CompanyDto companyDto){
        return ResponseEntity.status(HttpStatus.OK).body(new UserModel("bulbogc@gmail.com","1238425wky22"));
    }



    @GetMapping("/garoto")
    ResponseEntity<?> garoto(){
        GarotoModel garoto = new GarotoModel("gabriel","santos");
        return ResponseEntity.status(HttpStatus.OK).body(garoto);
    }







}
