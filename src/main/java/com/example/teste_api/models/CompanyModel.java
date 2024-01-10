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

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String cnpj;
    @Column(columnDefinition = "boolean default false")
    private  boolean paid;


    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<UserModel> employeelist;

    public CompanyModel() {
    }

    public CompanyModel(String name, String cnpj) {
        this.name = name;
        this.cnpj = cnpj;
    }

    public boolean isEmpty(){
        return  name == null;
    }


}
