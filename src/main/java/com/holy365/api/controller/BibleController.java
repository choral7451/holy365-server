package com.holy365.api.controller;

import com.holy365.api.dto.request.CompleteBibleTitle;
import com.holy365.api.dto.request.CompleteBibleVerse;
import com.holy365.api.dto.response.BibleTitleListResponse;
import com.holy365.api.dto.response.ChapterResponse;
import com.holy365.api.dto.response.VerseResponse;
import com.holy365.api.service.BibleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BibleController {

  private final BibleService bibleService;

  @GetMapping("/bible/titles")
  public BibleTitleListResponse getBible(Authentication authentication) {
    Long userId = null;
    if (authentication != null) {
      userId = (Long) authentication.getPrincipal();
    }
    return bibleService.getTitles(userId);
  }

  @GetMapping("/bible/{title}/chapters")
  public List<ChapterResponse> getTitleCount(Authentication authentication, @PathVariable(name = "title") String enTitle) {
    Long userId = (Long) authentication.getPrincipal();
    return bibleService.getChapters(userId, enTitle);
  }

  @GetMapping("/bible/{title}/{chapter}/verses")
  public List<VerseResponse> getVerses(Authentication authentication, @PathVariable(name = "title") String enTitle, @PathVariable(name = "chapter") Integer chapter) {
    Long userId = (Long) authentication.getPrincipal();
    return bibleService.getVerses(userId, enTitle, chapter);
  }

  @PostMapping("/bible/title/completion")
  public void completeBibleTitle(@RequestBody @Valid CompleteBibleTitle request, Authentication authentication) {
    Long userId = (Long) authentication.getPrincipal();
    bibleService.completeTitle(request.toCompleteBibleTitleCreator(userId));
  }

  @PostMapping("/bible/{title}/{chapter}/{verse}/completion")
  public void completeBibleTitle(
    Authentication authentication,
    @PathVariable(name = "title") String enTitle,
    @PathVariable(name = "chapter") Integer chapter,
    @PathVariable(name = "verse") Integer verse
  ) {
    Long userId = (Long) authentication.getPrincipal();
    CompleteBibleVerse completeBibleVerse = CompleteBibleVerse.builder()
      .userId(userId)
      .title(enTitle)
      .chapter(chapter)
      .verse(verse)
      .build();

    bibleService.completeVerse(completeBibleVerse);
  }
}
