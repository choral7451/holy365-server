package com.holy365.api.controller;

import com.holy365.api.response.BibleTitleResponse;
import com.holy365.api.response.VerseResponse;
import com.holy365.api.service.BibleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BibleController {

  private final BibleService bibleService;

  @GetMapping("/bible/titles")
  public List<BibleTitleResponse> getBible() {
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
}
