package com.example.teste_api.dtos;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;


public record CompanyDto(
                         @NotEmpty(message = "O campo companyName não pode ser vazio")
                         String companyName ,
                         @NotEmpty(message = "O campo Email não pode ser vazio")
                         @Email(message = "email informado é inválido")
                         String email,
                         @NotEmpty(message = "O campo senha não pode ser vazio")
                         String password ,
                         @NotEmpty(message = "O campo nome não pode ser vazio")
                         String name,

                         @NotEmpty(message = "O campo cnpj não pode ser vazio")
                         @CNPJ(message = "cnpj inválido")
                         String cnpj
)
{
    public CompanyDto {

    }
}
