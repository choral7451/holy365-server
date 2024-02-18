package com.holy365.api.dto.request;

import com.holy365.api.dto.EmailSignupCreator;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Signup {
  @NotBlank(message = "사용자 닉네임을 입력해 주세요.")
  private String nickname;

  @NotBlank(message = "사용자 이름을 입력해 주세요.")
  private String name;

  @NotBlank(message = "사용자 이메일을 입력해 주세요.")
  private String email;

  @NotBlank(message = "사용자 비밀번호를 입력해 주세요.")
  private String password;

  public EmailSignupCreator toEmailSignupCreator() {
    return EmailSignupCreator.builder()
      .nickname(this.nickname)
      .name(this.name)
      .email(this.email)
      .password(this.password)
      .build();
  }
}
