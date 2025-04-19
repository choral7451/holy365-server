package goj.holy365.api.bible.infrastructure.mapper;

import goj.holy365.api.bible.domain.model.BibleVerse;
import goj.holy365.api.bible.infrastructure.entity.BibleVerseEntity;

public class BibleVerseMapper {
	static public BibleVerse toDomain(BibleVerseEntity entity) {
		return new BibleVerse(
			entity.getId(),
			BibleVersionMapper.toDomain(entity.getVersion()),
			BibleBookMapper.toDomain(entity.getBook()),
			entity.getChapter(),
			entity.getVerse(),
			entity.getContent(),
			entity.getCreatedAt(),
			entity.getUpdatedAt(),
			entity.getDeletedAt()
		);
	}

	static public BibleVerseEntity toEntity(BibleVerse domain) {
		return BibleVerseEntity.builder()
			.id(domain.getId())
			.version(BibleVersionMapper.toEntity(domain.getVersion()))
			.book(BibleBookMapper.toEntity(domain.getBook()))
			.chapter(domain.getChapter())
			.verse(domain.getVerse())
			.content(domain.getContent())
			.createdAt(domain.getCreatedAt())
			.updatedAt(domain.getUpdatedAt())
			.deletedAt(domain.getDeletedAt())
			.build();
	}
}
