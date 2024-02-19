package com.holy365.api.dto.request;

import com.holy365.api.dto.CompleteBibleTitleCreator;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CompleteBibleTitle {

  @NotBlank(message = "성경 제목을 입력해 주세요.")
  private String title;

  public CompleteBibleTitle(){}

  public CompleteBibleTitleCreator toCompleteBibleTitleCreator(Long userId) {
    return CompleteBibleTitleCreator.builder()
      .koTitle(this.title)
      .userId(userId)
      .build();
  }
}
