package com.example.teste_api.dtos;

import com.example.teste_api.enums.UserRoleEnums;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;


public record CompanyDto(
                         @NotEmpty
                         String companyName ,
                         @NotEmpty
                         @Email
                         String email,
                         @NotEmpty
                         @NotBlank
                         String password ,
                         @NotEmpty
                         String name,
                         @NotEmpty
                         UserRoleEnums role,
                         @NotEmpty
                         @NotBlank
                         @CNPJ
                         String cnpj
) {
}
