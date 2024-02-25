package com.holy365.api.dto.request;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CompleteBibleVerse {
  private Long userId;
  private String title;
  private Integer chapter;
  private Integer verse;
}
