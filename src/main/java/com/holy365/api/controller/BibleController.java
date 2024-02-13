package com.holy365.api.controller;

import com.holy365.api.service.BibleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BibleController {

  private final BibleService bibleService;

  @GetMapping("/bible/titles")
  public List<String> getBible() {
    return bibleService.getTitles();
  }

  @GetMapping("/bible/count")
  public Integer getTitleCount() {
    return bibleService.countByTitle("창세기");
  }
}
