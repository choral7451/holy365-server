package com.holy365.api.domain.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum BibleCategory implements EnumType {
  OLD("구약"),
  NEW("신약");

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
