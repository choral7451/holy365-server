package goj.holy365.api.infrastructure.mapper;

import goj.holy365.api.domain.model.BibleVersion;
import goj.holy365.api.infrastructure.entity.BibleVersionEntity;

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
			.id(domain.id())
			.code(domain.code())
			.nameKo(domain.nameKo())
			.nameEn(domain.nameEn())
			.createdAt(domain.createdAt())
			.updatedAt(domain.updatedAt())
			.deletedAt(domain.deletedAt())
			.build();
	}
}
