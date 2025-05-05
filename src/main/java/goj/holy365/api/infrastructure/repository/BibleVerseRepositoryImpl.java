package goj.holy365.api.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import goj.holy365.api.domain.interfaces.BibleVerseRepository;
import goj.holy365.api.domain.model.BibleVerse;
import goj.holy365.api.infrastructure.entity.BibleVerseEntity;
import goj.holy365.api.infrastructure.entity.QBibleVerseEntity;
import goj.holy365.api.infrastructure.mapper.BibleVerseMapper;
import goj.holy365.api.infrastructure.persistence.BibleVerseJpaRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BibleVerseRepositoryImpl implements BibleVerseRepository {
	private final BibleVerseJpaRepository bibleVerseJpaRepository;
	private final JPAQueryFactory queryFactory;
	private final QBibleVerseEntity verse = QBibleVerseEntity.bibleVerseEntity;

	@Override
	public List<BibleVerse> scanVerses(Long versionId, Long bookId, Integer chapter) {
		List<BibleVerseEntity> entities = this.bibleVerseJpaRepository.findByVersionIdAndBookIdAndChapterOrderByOrderIndexAsc(
			versionId, bookId, chapter);

		return entities.stream().map(BibleVerseMapper::toDomain).toList();
	}

	@Override
	public List<Integer> scanChapters(Long versionId, Long bookId) {
		return queryFactory
			.select(verse.chapter)
			.distinct()
			.from(verse)
			.where(
				verse.versionId.eq(versionId),
				verse.bookId.eq(bookId)
			)
			.orderBy(verse.chapter.asc())
			.fetch();
	}
}
