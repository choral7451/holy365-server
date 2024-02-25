package com.holy365.api.repository;

import com.holy365.api.domain.bible.BibleStatusChapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BibleStatusChapterRepository extends JpaRepository<BibleStatusChapter, Long> {

  List<BibleStatusChapter> findAllByUser_IdAndEnTitle(Long userId, String title);
}
