package com.example.teste_api.services;

import com.example.teste_api.dtos.CompanyDto;
import com.example.teste_api.dtos.UserDto;
import com.example.teste_api.models.CompanyModel;
import com.example.teste_api.models.UserModel;
import com.example.teste_api.repositories.CompanyRepository;
import jakarta.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    @Transactional
    public CompanyModel createCompany(@NotNull CompanyDto companyDto){
        CompanyModel companyModel = new CompanyModel(companyDto.companyName(),companyDto.cnpj());
        CompanyModel existCompany = companyRepository.findByCnpj(companyModel.getCnpj());
        if(existCompany.isEmpty()){
            return companyRepository.save(companyModel);
        }
        throw new Error("a empresa informada ja está cadastrada no sistema");
    }

    public void deleteCompany(UUID companyId){
        Optional<CompanyModel> company0 =  companyRepository.findById(companyId);
        if(company0.isEmpty()){
            throw new Error("usuario não encontrado no sistema, por favor informe um id de empresa válido");
        }
    }

    public List<CompanyModel> getAllCompanies(){

        try{
            return  companyRepository.findAll();
        }catch (Error e){
            throw new Error("erro na busca no banco de dados: " + e);
        }


    }

    public Optional<CompanyModel>  getCompany(UUID companyId){
        try{
            return  companyRepository.findById(companyId);
        }catch (Error e){
            throw new Error("erro na busca no banco de dados: " + e);
        }
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
