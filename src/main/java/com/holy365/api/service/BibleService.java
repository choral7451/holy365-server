package com.holy365.api.service;

import com.holy365.api.repository.user.BibleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BibleService {

  private final BibleRepository bibleRepository;

  public List<String> getTitles() {
    return bibleRepository.findDistinctTitles();
  }

  public Integer countByTitle(String title) {
    return bibleRepository.countDistinctChaptersByTitle(title);
  }
}
