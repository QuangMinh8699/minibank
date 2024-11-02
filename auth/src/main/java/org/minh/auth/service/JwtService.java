package org.minh.auth.service;

import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.Function;

@Service
public interface JwtService {
    String extractUsername(String token);

    <T> T extractClaims(String token, Function<Claims, T> claimsResolver);

    String generateToken(Map<String, Object> extraClaims, String username);

    String generateToken(String username);

    boolean isTokenValid(String token, String username);
}
