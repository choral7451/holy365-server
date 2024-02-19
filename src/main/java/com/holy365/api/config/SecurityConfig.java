package com.holy365.api.config;


import com.holy365.api.config.handler.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

  @Value("${holy365.secret_key}")
  private String secretKey;

  private final ObjectMapper objectMapper;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
      .headers(
        headersConfigurer ->
          headersConfigurer
            .frameOptions(
              HeadersConfigurer.FrameOptionsConfig::sameOrigin
            )
      )
      .authorizeHttpRequests(request -> request
        .requestMatchers("/bible/{title}/{chapter}/verses").authenticated()
        .anyRequest().permitAll()
      )
      .csrf(AbstractHttpConfigurer::disable)
      .addFilterBefore(new JwtFilter(secretKey), UsernamePasswordAuthenticationFilter.class)
      .exceptionHandling(e -> {
        e.authenticationEntryPoint(new Http401Handler(objectMapper));
      })
      .build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new SCryptPasswordEncoder(16, 8, 1, 32, 64);
  }
}
