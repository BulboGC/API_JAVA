package com.example.teste_api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

public record EmailDto(
        @NotBlank String ownerRef,
        @NotBlank @Email String emailFrom,
        @NotBlank @Email String emailTo,
        @NotBlank String subject,
        @NotBlank String text
) {
}