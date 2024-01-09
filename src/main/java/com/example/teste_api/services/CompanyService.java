package com.example.teste_api.services;

import com.example.teste_api.models.CompanyModel;
import com.example.teste_api.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;


}
