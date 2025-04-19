package goj.holy365.api.bible.infrastructure.mapper;

import goj.holy365.api.bible.domain.model.BibleVersion;
import goj.holy365.api.bible.infrastructure.entity.BibleVersionEntity;

public class BibleVersionMapper {
	static public BibleVersion toDomain(BibleVersionEntity entity) {
		return new BibleVersion(
			entity.getId(),
			entity.getCode(),
			entity.getNameKo(),
			entity.getNameEn(),
			entity.getCreatedAt(),
			entity.getUpdatedAt(),
			entity.getDeletedAt()
		);
	}

	static public BibleVersionEntity toEntity(BibleVersion domain) {
		return BibleVersionEntity.builder()
			.id(domain.getId())
			.code(domain.getCode())
			.nameKo(domain.getNameKo())
			.nameEn(domain.getNameEn())
			.createdAt(domain.getCreatedAt())
			.updatedAt(domain.getUpdatedAt())
			.deletedAt(domain.getDeletedAt())
			.build();
	}
}
