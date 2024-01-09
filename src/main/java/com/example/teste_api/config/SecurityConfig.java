package com.example.teste_api.config;

import org.springframework.boot.autoconfigure.security.oauth2.server.servlet.OAuth2AuthorizationServerJwtAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig  {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws  Exception{
        return httpSecurity.authorizeHttpRequests(
                autorizeConfig ->{

                    autorizeConfig.requestMatchers(HttpMethod.POST,"/login").permitAll();
                    autorizeConfig.requestMatchers(HttpMethod.POST,"/signin").permitAll();
                    autorizeConfig.anyRequest().authenticated();
                }
        ).formLogin(Customizer.withDefaults()).build();
    }

}
