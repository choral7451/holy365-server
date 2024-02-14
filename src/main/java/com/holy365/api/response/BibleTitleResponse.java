package com.holy365.api.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BibleTitleResponse {
  private String enTitle;
  private String koTitle;
}
