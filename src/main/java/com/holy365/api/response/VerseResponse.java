package com.holy365.api.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VerseResponse {
  private Integer verse;
  private String text;
}
