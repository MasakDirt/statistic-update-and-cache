package org.techtask.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.techtask.exception.InvalidDataException;

import java.security.Key;
import java.util.Date;

@Slf4j
@Component
public class JwtUtils {

    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    @Value("${jwt.inspiration.ms}")
    private long inspirationMs;

    public String generateTokenFromUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new InvalidDataException("Username must contain at least one letter");
        }

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + inspirationMs))
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    public boolean isJwtTokenValid(String token) {
        isValidToken(token);

        try {
            Jwts.parserBuilder()
                    .setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException malformedJwtException) {
            log.error("Invalid JWT token: {}", malformedJwtException.getMessage());
        } catch (ExpiredJwtException expiredJwtException) {
            log.error("JWT token is expired: {}", expiredJwtException.getMessage());
        } catch (UnsupportedJwtException unsupportedJwtException) {
            log.error("JWT token is unsupported: {}", unsupportedJwtException.getMessage());
        } catch (IllegalArgumentException illegalArgumentException) {
            log.error("JWT claims string is empty: {}", illegalArgumentException.getMessage());
        } catch (SignatureException signatureException) {
            log.error("JWT signature does not match locally computed signature: {}", signatureException.getMessage());
        }

        return false;
    }

    public String getSubject(String token) {
        isValidToken(token);

        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    private void isValidToken(String checking) {
        if (isStringNullOrEmptyOrHasSmallLength(checking)) {
            throw new InvalidDataException("Token must contain at least 10 letters.");
        }
    }

    private boolean isStringNullOrEmptyOrHasSmallLength(String checking) {
        return checking == null || checking.trim().isEmpty()
                || checking.length() < 10;
    }

}
