package goj.holy365.api.bible.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import goj.holy365.api.bible.domain.interfaces.BibleVerseRepository;
import goj.holy365.api.bible.domain.model.BibleVerse;
import goj.holy365.api.bible.infrastructure.entity.BibleVerseEntity;
import goj.holy365.api.bible.infrastructure.mapper.BibleVerseMapper;
import goj.holy365.api.bible.infrastructure.persistence.BibleVerseJpaRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BibleVerseRepositoryImpl implements BibleVerseRepository {
	private final BibleVerseJpaRepository bibleVerseJpaRepository;

	public List<BibleVerse> scanVerses(Long versionId, Long bookId) {
		List<BibleVerseEntity> entities = this.bibleVerseJpaRepository.findByVersionIdAndBookIdOrderByChapterAscVerseAsc(
			versionId, bookId);

		return entities.stream().map(BibleVerseMapper::toDomain).toList();
	}

}
