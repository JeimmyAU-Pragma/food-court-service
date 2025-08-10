package com.pragma.foodcourt.infrastructure.security.jwt;

import io.jsonwebtoken.JwtException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String accessTokenSecret;

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(accessTokenSecret.getBytes())).build().parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(accessTokenSecret.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }


}

