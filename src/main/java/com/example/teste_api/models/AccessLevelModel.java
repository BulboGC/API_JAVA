package com.example.teste_api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_access_level")
public class AccessLevelModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private Integer level;
    private String sector_name;
    


    public AccessLevelModel() {
    }

    public AccessLevelModel(Integer level, String sector_name) {
        this.level = level;
        this.sector_name = sector_name;
    }


    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLevel(), getSector_name());
    }

    @Override
    public String toString() {
        return "AccessLevelModel{" +
                "level=" + level +
                ", sector_name='" + sector_name + '\'' +
                '}';
    }
}
