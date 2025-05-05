package goj.holy365.api.infrastructure.mapper;

import goj.holy365.api.domain.model.BibleBook;
import goj.holy365.api.infrastructure.entity.BibleBookEntity;

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
			.id(domain.id())
			.testament(domain.testament())
			.nameKo(domain.nameKo())
			.nameEn(domain.nameEn())
			.orderIndex(domain.orderIndex())
			.createdAt(domain.createdAt())
			.updatedAt(domain.updatedAt())
			.deletedAt(domain.deletedAt())
			.build();
	}
}
