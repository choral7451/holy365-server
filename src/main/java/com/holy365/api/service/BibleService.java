package com.holy365.api.service;

import com.holy365.api.domain.User;
import com.holy365.api.domain.bible.BibleStatusTitle;
import com.holy365.api.dto.CompleteBibleTitleCreator;
import com.holy365.api.exception.BibleNotFound;
import com.holy365.api.exception.UserNotFound;
import com.holy365.api.repository.BibleRepository;
import com.holy365.api.dto.response.BibleTitleResponse;
import com.holy365.api.dto.response.VerseResponse;
import com.holy365.api.repository.BibleStatusTitleRepository;
import com.holy365.api.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BibleService {

  private final UserRepository userRepository;
  private final BibleRepository bibleRepository;
  private final BibleStatusTitleRepository bibleStatusTitleRepository;

  public List<BibleTitleResponse> getTitles(Long userId) {
    List<BibleStatusTitle> completedTitles = new ArrayList<>();
    if(userId != null) {
      completedTitles = bibleStatusTitleRepository.findAllByUser_Id(userId);
    }

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

  public void completeTitle(CompleteBibleTitleCreator creator) {
    Boolean existingBible = bibleRepository.existsBibleByKoTitle(creator.getKoTitle());
    if (!existingBible) {
      throw new BibleNotFound();
    }

    User user = userRepository.findById(creator.getUserId())
      .orElseThrow(UserNotFound::new);

    Optional<BibleStatusTitle> status = bibleStatusTitleRepository.findBibleStatusTitleByTitleAndUser_Id(creator.getKoTitle(), creator.getUserId());
    if (status.isEmpty()) {
      BibleStatusTitle bibleStatusTitle = BibleStatusTitle.builder()
        .title(creator.getKoTitle())
        .user(user)
        .build();

      bibleStatusTitleRepository.save(bibleStatusTitle);
    }
  }
}
