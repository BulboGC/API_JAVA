package com.example.teste_api.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;


@Entity
@Table (name= "TB_PRODUCTS")
public class ProductModel implements Serializable {

    private static final long seralVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private  String name;
    private BigDecimal price;







    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }



    @Override
    public String toString() {
        return "Produto:{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


}
