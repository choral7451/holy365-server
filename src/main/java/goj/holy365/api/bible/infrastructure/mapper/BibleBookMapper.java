package goj.holy365.api.bible.infrastructure.mapper;

import goj.holy365.api.bible.domain.model.BibleBook;
import goj.holy365.api.bible.infrastructure.entity.BibleBookEntity;

public class BibleBookMapper {
	static public BibleBook toDomain(BibleBookEntity entity) {
		return new BibleBook(
			entity.getId(),
			entity.getTestament(),
			entity.getNameKo(),
			entity.getNameEn(),
			entity.getOrderIndex(),
			entity.getCreatedAt(),
			entity.getUpdatedAt(),
			entity.getDeletedAt()
		);
	}

	static public BibleBookEntity toEntity(BibleBook domain) {
		return BibleBookEntity.builder()
			.id(domain.getId())
			.testament(domain.getTestament())
			.nameKo(domain.getNameKo())
			.nameEn(domain.getNameEn())
			.orderIndex(domain.getOrderIndex())
			.createdAt(domain.getCreatedAt())
			.updatedAt(domain.getUpdatedAt())
			.deletedAt(domain.getDeletedAt())
			.build();
	}
}
