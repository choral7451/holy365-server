package com.holy365.api.service;

import com.holy365.api.common.util.JwtUtil;
import com.holy365.api.domain.Auth;
import com.holy365.api.domain.User;
import com.holy365.api.domain.enums.AuthType;
import com.holy365.api.dto.LoginCreator;
import com.holy365.api.dto.EmailSignupCreator;
import com.holy365.api.exception.LoginException;
import com.holy365.api.repository.AuthRepository;
import com.holy365.api.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

  @Value("${holy365.secret_key}")
  private String PRIVATE_KEY;

  private final UserRepository userRepository;
  private final AuthRepository authRepository;
  private final PasswordEncoder passwordEncoder;

  public void signupByEmail(EmailSignupCreator creator) {
    String encryptedPassword = passwordEncoder.encode(creator.getPassword());

    User user = User.builder()
      .email(creator.getEmail())
      .name(creator.getName())
      .nickname(creator.getNickname())
      .build();

    userRepository.save(user);

    Auth auth = Auth.builder()
      .identity(creator.getEmail())
      .password(encryptedPassword)
      .type(AuthType.EMAIL)
      .user(user)
      .build();

    authRepository.save(auth);
  }

  public String login(LoginCreator loginCreator) {
    Auth auth = authRepository.findByIdentity(loginCreator.getEmail())
      .orElseThrow(LoginException::new);

    boolean matchResult = passwordEncoder.matches(loginCreator.getPassword(), auth.getPassword());
    if (!matchResult) {
      throw new LoginException();
    }

    Long expiredMs = 1000 * 60 * 60L;
    return JwtUtil.createJwt(PRIVATE_KEY, expiredMs);
  }
}
