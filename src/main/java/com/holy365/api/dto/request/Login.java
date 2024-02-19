package com.holy365.api.dto.request;

import com.holy365.api.dto.LoginCreator;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Login {
  @NotBlank(message = "사용자 아이디를 입력해 주세요.")
  private String email;

  @NotBlank(message = "사용자 패스워드를 입력해 주세요.")
  private String password;

  public LoginCreator toCreator() {
    return LoginCreator.builder()
      .email(this.email)
      .password(this.password)
      .build();
  }
}
