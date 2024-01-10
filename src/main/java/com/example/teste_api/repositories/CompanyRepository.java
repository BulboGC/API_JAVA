package com.example.teste_api.repositories;

import com.example.teste_api.models.CompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface CompanyRepository extends JpaRepository<CompanyModel, UUID> {
   CompanyModel findByCnpj(String cnpj);
}
