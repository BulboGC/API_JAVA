package com.example.teste_api.models;

import lombok.Data;

@Data
public class GarotoModel {
    private String name;
    private String sobrenome;

    public GarotoModel(String name, String sobrenome) {
        this.name = name;
        this.sobrenome = sobrenome;
    }
}
