package com.holy365.api.common.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.SecretKey;
import java.util.Date;

@Slf4j
public class JwtUtil {

  public static Long getUserId(String token, String secretKey) {
    SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());

    return Jwts.parser().verifyWith(key).build().parseSignedClaims(token)
      .getPayload().get("userId", Long.class);
  }

  public static boolean validateToken(String token, String secretKey) {
    try {
      SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());

      Jwts.parser().verifyWith(key).build().parseSignedClaims(token);
      return true;
    } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
      log.info("잘못된 JWT 서명입니다.");
    } catch (ExpiredJwtException e) {
      log.info("만료된 JWT 토큰입니다.");
    } catch (UnsupportedJwtException e) {
      log.info("지원되지 않는 JWT 토큰입니다.");
    } catch (IllegalArgumentException e) {
      log.info("JWT 토큰이 잘못되었습니다.");
    }
    return false;
  }

  public static String createJwt( String secretKey, Long expiredMs) {

    SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());

    return Jwts.builder()
      .claim("userId", 1L)
      .issuedAt(new Date(System.currentTimeMillis()))
      .expiration(new Date(System.currentTimeMillis() + expiredMs))
      .signWith(key)
      .compact();
  }
}
