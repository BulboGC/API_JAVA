package com.example.teste_api.repositories;

import com.example.teste_api.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {
    UserModel findByEmail(String email);

    UserModel findByUuid(UUID uuid);


    @Query("SELECT u FROM UserModel u WHERE u.company.uuid = :companyUuid")
    List<UserModel> findByCompanyUuid(@Param("companyUuid") UUID companyUuid);
}
