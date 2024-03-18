package com.example.teste_api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "tb_count_sector")
public class CountSectorModel {

    @Id
    private UUID id;

    private long count;
    private String sector;


    public CountSectorModel(UUID id,  String sector) {
        this.id =  id;
        this.count = 1;
        this.sector = sector;
    }

    public void increment(){
        count = count + 1;
    }

    public void decrement(){count = count - 1;}



}
