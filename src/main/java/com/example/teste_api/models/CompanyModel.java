package com.example.teste_api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_company")
public class CompanyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    private String name;
    private  boolean paid;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<UserModel> employeelist;

}
