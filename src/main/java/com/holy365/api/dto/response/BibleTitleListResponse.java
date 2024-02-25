package com.holy365.api.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class BibleTitleListResponse {
  private List<BibleTitleResponse> oldTestament;
  private List<BibleTitleResponse> newTestament;
}
