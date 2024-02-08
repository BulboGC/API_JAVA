package com.example.teste_api.models;


import com.example.teste_api.enums.UserRoleEnums;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



import java.util.Collection;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_user")
public class UserModel implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    private String email;
    private String password;
    private UserRoleEnums role;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "companyid", referencedColumnName = "uuid")
    private CompanyModel company;


    public boolean isEmpty() {
        return email == null && password == null && role == null && company == null;
    }

    public UserModel() {
    }

    public UserModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserModel(String email, String password, UserRoleEnums role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public UserModel(String email, String password, UserRoleEnums role, UUID company) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
