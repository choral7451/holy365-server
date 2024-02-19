package com.holy365.api.controller;

import com.holy365.api.dto.request.CompleteBibleTitle;
import com.holy365.api.dto.response.BibleTitleResponse;
import com.holy365.api.dto.response.VerseResponse;
import com.holy365.api.service.BibleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BibleController {

  private final BibleService bibleService;

  @GetMapping("/bible/titles")
  public List<BibleTitleResponse> getBible(Authentication authentication) {
    Long userId = null;
    if (authentication != null) {
      userId = (Long) authentication.getPrincipal();
    }
    return bibleService.getTitles();
  }

  @GetMapping("/bible/{title}/count")
  public Integer getTitleCount(@PathVariable(name = "title") String enTitle) {
    return bibleService.countByEnTitle(enTitle);
  }

  @GetMapping("/bible/{title}/{chapter}/verses")
  public List<VerseResponse> getVerses(@PathVariable(name = "title") String enTitle, @PathVariable(name = "chapter") Integer chapter) {
    return bibleService.getVerses(enTitle, chapter);
  }

  @PostMapping("/bible/title/completion")
  public void completeBibleTitle(@RequestBody @Valid CompleteBibleTitle request, Authentication authentication) {
    Long userId = (Long) authentication.getPrincipal();
    bibleService.completeTitle(request.toCompleteBibleTitleCreator(userId));
  }
}
