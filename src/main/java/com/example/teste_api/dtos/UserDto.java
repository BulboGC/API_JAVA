package com.example.teste_api.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.UUID;

public record UserDto(

        @Email
        @NotBlank
        String email,
        @NotEmpty
        String pasword
) {
}
