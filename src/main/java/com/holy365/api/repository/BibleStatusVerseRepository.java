package com.holy365.api.repository;

import com.holy365.api.domain.bible.BibleStatusChapter;
import com.holy365.api.domain.bible.BibleStatusTitle;
import com.holy365.api.domain.bible.BibleStatusVerse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BibleStatusVerseRepository extends JpaRepository<BibleStatusVerse, Long> {

  List<BibleStatusVerse> findAllByUser_IdAndEnTitleAndChapter(Long userId, String title, Integer chapter);

  Optional<BibleStatusVerse> findBibleStatusVerseByUser_IdAndEnTitleAndChapterAndVerse(Long userId, String title, Integer chapter, Integer verse);
}
