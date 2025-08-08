package com.pragma.foodCourt.infrastructure.security.jwt;

import io.jsonwebtoken.JwtException;

import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


@Component
public class JwtUtil {

    private final String ACCESS_TOKEN_SECRET = "Zy1vNcA3rBpX7LsGt49qWeJkMmPnRtUv";

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes())).build().parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }


}

