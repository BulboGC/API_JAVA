package com.example.teste_api.services;

import com.example.teste_api.dtos.CompanyDto;
import com.example.teste_api.dtos.UserDto;
import com.example.teste_api.enums.UserRoleEnums;
import com.example.teste_api.models.CompanyModel;
import com.example.teste_api.models.UserModel;
import com.example.teste_api.repositories.CompanyRepository;
import com.example.teste_api.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    AuxService auxService;


    @Transactional
    public CompanyModel createCompany( CompanyDto companyDto){

        CompanyModel companyModel = new CompanyModel(companyDto.companyName(),companyDto.cnpj());
        CompanyModel existCompany = companyRepository.findByCnpj(companyModel.getCnpj());
        if(existCompany != null){
            throw new Error("o cnpj informado já está cadastrado no sistema");
        }
        UserModel existUser = userRepository.findByEmail(companyDto.email());

        if(existUser == null){
            String password = auxService.passwordEncoder(companyDto.password());
            UserModel user0 = new  UserModel(companyDto.email(),password, UserRoleEnums.CEO);
            user0.setCompany(companyModel);
            companyModel.addEmployee(user0);
            return  companyRepository.save(companyModel);

        }else {
            throw new Error("O email informado ja esta cadastrado no sistema");
        }


    }


    public void deleteCompany(UUID companyId){
        Optional<CompanyModel> company0 =  companyRepository.findById(companyId);
        if(company0.isEmpty()){
            throw new Error("usuario não encontrado no sistema, por favor informe um id de empresa válido");
        }
    }

    public List<CompanyModel> getAllCompanies(){
            return  companyRepository.findAll();
    }

    public Optional<CompanyModel>  getCompany(UUID companyId){
            return  companyRepository.findById(companyId);

    }

    public CompanyModel updateCompany(UUID companyId,UserDto userDto){
       CompanyModel  company0  = companyRepository.findById(companyId).get();
       if(company0.isEmpty()){
           throw  new Error("o id informado não está cadastrado no sistema");
       }
       BeanUtils.copyProperties(userDto,company0);
       return companyRepository.save(company0);
    }

}
