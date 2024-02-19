package com.holy365.api.repository;

import com.holy365.api.domain.bible.BibleStatusTitle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BibleStatusTitleRepository extends JpaRepository<BibleStatusTitle, Integer> {

  List<BibleStatusTitle> findAllByUser_Id(Long userId);

  Optional<BibleStatusTitle> findBibleStatusTitleByTitleAndUser_Id(String title, Long userId);
}
