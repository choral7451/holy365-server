package goj.holy365.api.infrastructure.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import goj.holy365.api.infrastructure.entity.BibleVerseEntity;

public interface BibleVerseJpaRepository extends JpaRepository<BibleVerseEntity, Long> {
	List<BibleVerseEntity> findByVersionIdAndBookIdAndChapterOrderByOrderIndexAsc(Long versionId, Long bookId,
		Integer chapter);
}
