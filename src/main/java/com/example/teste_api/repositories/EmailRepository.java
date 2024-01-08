package com.example.teste_api.repositories;

import com.example.teste_api.models.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface EmailRepository extends JpaRepository<EmailModel, UUID> {

}
