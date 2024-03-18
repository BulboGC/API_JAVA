package com.example.teste_api.dtos;

import jakarta.validation.constraints.NotBlank;

public record AccessLevelRecord(
        @NotBlank Integer level,
        @NotBlank String sector_name
) {
}
