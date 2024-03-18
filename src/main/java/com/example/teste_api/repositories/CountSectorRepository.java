package com.example.teste_api.repositories;


import com.example.teste_api.models.CountSectorModel;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CountSectorRepository extends JpaRepository< CountSectorModel,UUID> {
    Optional<CountSectorModel> findById(UUID uuid);
    List<CountSectorModel> findAllByIdIn(List<UUID> uuids);

}
