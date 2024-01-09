package com.example.teste_api.dtos;

import com.example.teste_api.enums.UserRoleEnums;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record CompanyDto(@NotBlank String name,@NotEmpty int cnpj) {

}
