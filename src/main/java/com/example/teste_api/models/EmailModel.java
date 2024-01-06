package com.example.teste_api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table  (name= "TB_EMAILS")
public class EmailModel {

    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;
    @Column (columnDefinition = "TEXT")
    private String text;
}
