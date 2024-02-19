package com.holy365.api.repository;

import com.holy365.api.domain.bible.Bible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BibleRepository extends JpaRepository<Bible, Integer> {

  @Query("SELECT DISTINCT b.koTitle, b.enTitle FROM Bible b")
  List<Object[]> findDistinctTitles();

  Boolean existsBibleByKoTitle(String koTitle);

  @Query("SELECT COUNT(DISTINCT b.chapter) FROM Bible b WHERE b.enTitle = :enTitle")
  Integer countDistinctChaptersByEnTitle(@Param("enTitle") String enTitle);

  @Query("SELECT b.verse, b.contents FROM Bible b WHERE b.enTitle = :enTitle and b.chapter = :chapter order by b.verse ASC")
  List<Object[]> findVersesByEnTitleAndChapter(@Param("enTitle") String enTitle, @Param("chapter") Integer chapter);
}
