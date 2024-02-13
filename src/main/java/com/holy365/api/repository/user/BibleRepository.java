package com.holy365.api.repository.user;

import com.holy365.api.domain.Bible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BibleRepository extends JpaRepository<Bible, Integer> {

  @Query("SELECT DISTINCT b.title FROM Bible b")
  List<String> findDistinctTitles();

  @Query("SELECT COUNT(DISTINCT b.chapter) FROM Bible b WHERE b.title = :title")
  Integer countDistinctChaptersByTitle(@Param("title") String title);
}
