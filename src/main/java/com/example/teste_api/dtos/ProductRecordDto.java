package com.example.teste_api.dtos;

import org.antlr.v4.runtime.misc.NotNull;


import java.math.BigDecimal;

public record ProductRecordDto(String name, @NotNull BigDecimal price) {

}
