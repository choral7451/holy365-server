package com.holy365.api.controller;

import com.holy365.api.dto.request.Login;
import com.holy365.api.dto.request.Signup;
import com.holy365.api.dto.response.LoginResponse;
import com.holy365.api.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

  private final AuthService authService;

  @PostMapping("/signup")
  public void signup(@RequestBody @Valid Signup signup) {
    authService.signupByEmail(signup.toEmailSignupCreator());
  }

  @PostMapping("/login")
  public LoginResponse login(@RequestBody @Valid Login login) {
    String token = authService.login(login.toCreator());
    return LoginResponse.builder().accessToken(token).build();
  }
}
