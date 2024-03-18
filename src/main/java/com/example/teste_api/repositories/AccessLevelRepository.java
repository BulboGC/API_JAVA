package com.example.teste_api.repositories;

import com.example.teste_api.dtos.AccessLevelCountDto;
import com.example.teste_api.models.AccessLevelModel;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccessLevelRepository extends JpaRepository<AccessLevelModel, UUID> {
    Optional<AccessLevelModel> findById(UUID id);
    AccessLevelModel findByLevel(Integer level);
    List<AccessLevelModel> findByLevelLessThanEqual(Integer level);

}
