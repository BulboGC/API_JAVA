package com.example.teste_api.rules;

import com.example.teste_api.enums.UserRoleEnums;
import com.example.teste_api.enums.UserSectorEnum;
import com.example.teste_api.models.CompanyModel;
import com.example.teste_api.models.UserModel;
import com.example.teste_api.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class Rules {
  /*  @Autowired
    CompanyService companyService;

    private Integer min_show;
    private List<UserRoleEnums> sector_hierarchy;



    public List<UserRoleEnums> rolesToShow(UUID companyId , UserSectorEnum userSectorEnum){
      Optional<CompanyModel>  company = companyService.getCompany(companyId);
      if(company.isEmpty()) {
          throw new Error("envie um id de empresa válido.");
      }
      List<UserModel> employeelist =  company.get().getEmployeelist();

      Map<UserSectorEnum, Integer> sectorCountMap = new HashMap<>();

      employeelist.forEach(employee ->{

          UserSectorEnum employeeSector = employee.getSector();

          if(employeeSector.compareTo(userSectorEnum) > 0){
              sectorCountMap.put(employeeSector, sectorCountMap.getOrDefault(employeeSector, 0) + 1);
          }





        }
      );
    }*/
}
