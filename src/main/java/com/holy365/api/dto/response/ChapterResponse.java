package com.holy365.api.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ChapterResponse {
  private Integer chapter;
  private Boolean isCompleted;
}
