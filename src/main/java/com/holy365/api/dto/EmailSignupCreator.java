package com.holy365.api.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EmailSignupCreator {
  private String name;
  private String nickname;
  private String email;
  private String password;


}
