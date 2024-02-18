package com.holy365.api.domain.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum AuthType implements EnumType {
  EMAIL("이메일"),
  KAKAO("카카오"),
  NAVER("네이버"),
  GOOGLE("구글");



  private final String description;

  @Override
  public String getDescription() {
    return this.description;
  }

  @Override
  public String getName() {
    return this.name();
  }
  }
