package com.holy365.api.service;

import com.holy365.api.repository.user.BibleRepository;
import com.holy365.api.dto.response.BibleTitleResponse;
import com.holy365.api.dto.response.VerseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BibleService {

  private final BibleRepository bibleRepository;

  public List<BibleTitleResponse> getTitles() {
    return bibleRepository.findDistinctTitles().stream()
      .map(titles -> BibleTitleResponse.builder()
        .koTitle((String) titles[0])
        .enTitle((String) titles[1])
        .build())
      .toList();
  }

  public Integer countByEnTitle(String enTitle) {
    return bibleRepository.countDistinctChaptersByEnTitle(enTitle);
  }

  public List<VerseResponse> getVerses(String enTitle, Integer chapter) {
    return bibleRepository.findVersesByEnTitleAndChapter(enTitle, chapter).stream()
      .map(verse -> VerseResponse.builder()
        .verse((Integer) verse[0])
        .text((String) verse[1])
        .build())
      .toList();
  }
}
