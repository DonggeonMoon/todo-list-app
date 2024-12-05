package com.dgmoonlabs.todolistapp.member.application.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {
    @Value("${secret_key}")
    private String secretKey;

    @Value("${access_token_expiry_time}")
    private int accessTokenExpiryTime;

    @Value("${refresh_token_expiry_time}")
    private int refreshTokenExpiryTime;


    public String generateAccessToken(String username, String authorities) {
        SecretKey encryptedSecretKey = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
        return Jwts.builder()
                .issuer("dgmoonlabs")
                .subject("JWT Token")
                .claim("username", username)
                .claim("authorities", authorities)
                .issuedAt(new Date())
                .expiration(new Date(new Date().getTime() + accessTokenExpiryTime))
                .signWith(encryptedSecretKey)
                .compact();
    }

    public String generateRefreshToken(String username, String authorities) {
        SecretKey encryptedSecretKey = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
        return Jwts.builder()
                .issuer("dgmoonlabs")
                .subject("JWT Token")
                .claim("username", username)
                .claim("authorities", authorities)
                .issuedAt(new Date())
                .expiration(new Date(new Date().getTime() + refreshTokenExpiryTime))
                .signWith(encryptedSecretKey)
                .compact();
    }

    public boolean validate(String token) {
        try {
            SecretKey encryptedSecretKey = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
            Claims claims = Jwts.parser()
                    .verifyWith(encryptedSecretKey)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    claims.get("username", String.class),
                    null,
                    AuthorityUtils.commaSeparatedStringToAuthorityList(claims.get("authorities", String.class))
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
