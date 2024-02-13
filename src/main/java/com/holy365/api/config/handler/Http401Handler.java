package com.holy365.api.config.handler;

import com.holy365.api.response.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

import static jakarta.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;
import static java.nio.charset.StandardCharsets.UTF_8;


@Slf4j
@RequiredArgsConstructor
public class Http401Handler implements AuthenticationEntryPoint {

  private final ObjectMapper objectMapper;

  @Override
  public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
    log.error("[인증오류] 로그인이 필요합니다.");

    ErrorResponse errorResponse = ErrorResponse.builder()
      .code("401")
      .message("로그인이 필요합니다.")
      .build();

    String json = objectMapper.writeValueAsString(errorResponse);

    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    response.setCharacterEncoding(UTF_8.displayName());
    response.setStatus(SC_UNAUTHORIZED);
    objectMapper.writeValue(response.getWriter(), errorResponse);
  }
}
