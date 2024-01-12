package com.example.teste_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
class SecurityConfig{
@Bean
SecurityFilterChain web(HttpSecurity http) throws Exception {
    http
            // ...
            .authorizeHttpRequests(authorize -> authorize

                    .requestMatchers("/register","/garoto").permitAll()
                    .anyRequest().authenticated()




            );
    http.csrf().disable();

    return http.build();
}
}