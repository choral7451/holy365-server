package com.holy365.api.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginCreator {
  private String loginId;
  private String password;
}
