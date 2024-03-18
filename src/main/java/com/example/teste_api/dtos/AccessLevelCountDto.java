package com.example.teste_api.dtos;

import java.util.UUID;

public record AccessLevelCountDto(
        UUID id,
        Integer level,
       Long userCount
) {

}
