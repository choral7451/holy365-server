package com.holy365.api.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CompleteBibleTitleCreator {
  private Long userId;
  private String koTitle;
}
