
package com.example.teste_api.services;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class JwtService extends OAuth2ResourceServerProperties.Jwt {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private Long  jwtExpiration;

    public String generateToken(UUID userId,UUID companyId){
        Date now = new Date();

        Date expirationDate = new Date(now.getTime() + jwtExpiration);


        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userId.toString());
        claims.put("companyId", companyId.toString());

        return Jwts.builder()
                .setSubject(userId.toString())
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .setClaims(claims)
                .signWith(SignatureAlgorithm.ES256,jwtSecret)
                .compact();
    }



    public String validationToken(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();



            String userId = claims.get("userId", String.class);
            String companyId = claims.get("companyId", String.class);



            return userId +" "+ companyId;

        } catch (ExpiredJwtException e) {
            throw new Error("Token expirou: " + e);

        } catch (Exception e) {
            throw new Error("Token inválido: " + e);

        }
    }


}
