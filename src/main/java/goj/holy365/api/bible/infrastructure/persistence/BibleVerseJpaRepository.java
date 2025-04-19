package goj.holy365.api.bible.infrastructure.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import goj.holy365.api.bible.infrastructure.entity.BibleVerseEntity;

public interface BibleVerseJpaRepository extends JpaRepository<BibleVerseEntity, Long> {
	List<BibleVerseEntity> findByVersionIdAndBookIdOrderByChapterAscVerseAsc(Long versionId, Long bookId);
}
