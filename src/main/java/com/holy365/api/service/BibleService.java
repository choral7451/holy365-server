package com.holy365.api.service;

import com.holy365.api.domain.User;
import com.holy365.api.domain.bible.BibleStatusChapter;
import com.holy365.api.domain.bible.BibleStatusTitle;
import com.holy365.api.domain.bible.BibleStatusVerse;
import com.holy365.api.domain.enums.BibleCategory;
import com.holy365.api.dto.CompleteBibleTitleCreator;
import com.holy365.api.dto.request.CompleteBibleVerse;
import com.holy365.api.dto.response.BibleTitleListResponse;
import com.holy365.api.dto.response.ChapterResponse;
import com.holy365.api.exception.BibleNotFound;
import com.holy365.api.exception.UserNotFound;
import com.holy365.api.repository.BibleRepository;
import com.holy365.api.dto.response.BibleTitleResponse;
import com.holy365.api.dto.response.VerseResponse;
import com.holy365.api.repository.BibleStatusChapterRepository;
import com.holy365.api.repository.BibleStatusTitleRepository;
import com.holy365.api.repository.BibleStatusVerseRepository;
import com.holy365.api.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BibleService {

  private final UserRepository userRepository;
  private final BibleRepository bibleRepository;
  private final BibleStatusTitleRepository bibleStatusTitleRepository;
  private final BibleStatusChapterRepository bibleStatusChapterRepository;
  private final BibleStatusVerseRepository bibleStatusVerseRepository;

  public BibleTitleListResponse getTitles(Long userId) {
    List<BibleStatusTitle> completedTitles;
    if(userId != null) {
      completedTitles = bibleStatusTitleRepository.findAllByUser_Id(userId);
    } else {
      completedTitles = new ArrayList<>();
    }

    List<BibleTitleResponse> oldTestament = new ArrayList<>();
    List<BibleTitleResponse> newTestament = new ArrayList<>();


    bibleRepository.findDistinctTitles().forEach(titles -> {
      String koTitle = (String) titles[0];
      String enTitle = (String) titles[1];
      BibleCategory category = (BibleCategory) titles[2];
      Boolean isCompleted = isCompletedTitle(completedTitles, koTitle);

      BibleTitleResponse bibleTitleResponse = BibleTitleResponse.builder()
        .koTitle(koTitle)
        .enTitle(enTitle)
        .isCompleted(isCompleted)
        .build();

      if (category == BibleCategory.NEW) {
        newTestament.add(bibleTitleResponse);
      } else {
        oldTestament.add(bibleTitleResponse);
      }
    });

    return BibleTitleListResponse.builder()
      .oldTestament(oldTestament)
      .newTestament(newTestament)
      .build();
  }

  private Boolean isCompletedTitle(List<BibleStatusTitle> completedTitles, String title) {
    for (BibleStatusTitle completedTitle : completedTitles) {
      if(completedTitle.getTitle().equals(title)) return true;
    }

    return false;
  }

  public List<ChapterResponse> getChapters(Long userId, String enTitle) {
    List<BibleStatusChapter> completedChapters = bibleStatusChapterRepository.findAllByUser_IdAndEnTitle(userId, enTitle);

    Integer numberOfChapters = bibleRepository.countDistinctChaptersByEnTitle(enTitle);

    List<ChapterResponse> response = new ArrayList<>();
    for (Integer i = 1; i <= numberOfChapters; i++) {
      Boolean isCompleted = isCompletedChapter(completedChapters,  i);

      ChapterResponse chapterResponse = ChapterResponse.builder()
        .chapter(i)
        .isCompleted(isCompleted)
        .build();

      response.add(chapterResponse);
    }

    return response;
  }

  private Boolean isCompletedChapter(List<BibleStatusChapter> completedChapters, Integer chapter) {
    for (BibleStatusChapter completedChapter : completedChapters) {
      if(Objects.equals(completedChapter.getChapter(), chapter)) return true;
    }

    return false;
  }

  public List<VerseResponse> getVerses(Long userId, String enTitle, Integer chapter) {
    List<BibleStatusVerse> completedVerses = bibleStatusVerseRepository.findAllByUser_IdAndEnTitleAndChapter(userId, enTitle, chapter);

    List<Object[]> verses = bibleRepository.findVersesByEnTitleAndChapter(enTitle, chapter);

    return verses.stream().map(verseAndContent -> {
      Integer verse = (Integer) verseAndContent[0];
      String content = (String) verseAndContent[1];
      Boolean isCompleted = isCompletedVerse(completedVerses, verse);

      return VerseResponse.builder()
        .verse(verse)
        .text(content)
        .isCompleted(isCompleted)
        .build();
    }).toList();
  }

  private Boolean isCompletedVerse(List<BibleStatusVerse> completedVerses, Integer verse) {
    for (BibleStatusVerse completedVerse : completedVerses) {
      if(Objects.equals(completedVerse.getVerse(), verse)) return true;
    }

    return false;
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

  public void completeVerse(CompleteBibleVerse completeBibleVerse) {
    Boolean existingBible = bibleRepository.existsBibleByEnTitleAndChapterAndVerse(completeBibleVerse.getTitle(), completeBibleVerse.getChapter(), completeBibleVerse.getVerse());
    if (!existingBible) {
      throw new BibleNotFound();
    }

    User user = userRepository.findById(completeBibleVerse.getUserId())
      .orElseThrow(UserNotFound::new);

    Optional<BibleStatusVerse> status = bibleStatusVerseRepository.findBibleStatusVerseByUser_IdAndEnTitleAndChapterAndVerse(
      completeBibleVerse.getUserId(),
      completeBibleVerse.getTitle(),
      completeBibleVerse.getChapter(),
      completeBibleVerse.getVerse()
    );

    if (status.isEmpty()) {
      BibleStatusVerse bibleStatusVerse = BibleStatusVerse.builder()
        .enTitle(completeBibleVerse.getTitle())
        .chapter(completeBibleVerse.getChapter())
        .verse(completeBibleVerse.getVerse())
        .user(user)
        .build();

      bibleStatusVerseRepository.save(bibleStatusVerse);
    }
  }
}
