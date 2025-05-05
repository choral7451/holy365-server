package goj.holy365.api.infrastructure.mapper;

import goj.holy365.api.domain.model.BibleVerse;
import goj.holy365.api.infrastructure.entity.BibleVerseEntity;

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
			.id(domain.id())
			.version(BibleVersionMapper.toEntity(domain.version()))
			.book(BibleBookMapper.toEntity(domain.book()))
			.chapter(domain.chapter())
			.verse(domain.verse())
			.content(domain.content())
			.createdAt(domain.createdAt())
			.updatedAt(domain.updatedAt())
			.deletedAt(domain.deletedAt())
			.build();
	}
}
