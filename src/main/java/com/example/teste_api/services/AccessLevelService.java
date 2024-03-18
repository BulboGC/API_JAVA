package com.example.teste_api.services;


import com.example.teste_api.models.AccessLevelModel;

import com.example.teste_api.models.CountSectorModel;
import com.example.teste_api.repositories.AccessLevelRepository;
import com.example.teste_api.repositories.CountSectorRepository;
import com.example.teste_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AccessLevelService {
    private final Long minShow = 5L;
    @Autowired
    AccessLevelRepository accessLevelRepository;
    @Autowired
    CountSectorRepository countSectorRepository;

    @Autowired
    UserRepository userRepository;


    //ve um level e fala a hierarquia, de quais niveis estao abaixo
    public List<AccessLevelModel> hierarchyShow(Integer level){
        return accessLevelRepository.findByLevelLessThanEqual(level);
    }



    //retorna uma lista de id de sector para tirar do filtro estao com menos de 5 pessoas para retirar eles do filtro
    public List<UUID> banListRules(){
       List<CountSectorModel> count =  countSectorRepository.findAll();

       List<UUID> list = new ArrayList<UUID>();

        count.forEach(accessLevelCountDto ->{
           if(accessLevelCountDto.getCount() < minShow){
                list.add(accessLevelCountDto.getId());
           }
       });
       return list;
    }



}
