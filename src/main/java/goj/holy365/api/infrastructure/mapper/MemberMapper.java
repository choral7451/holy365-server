package goj.holy365.api.infrastructure.mapper;

import goj.holy365.api.domain.model.Member;
import goj.holy365.api.infrastructure.entity.MemberEntity;

public class MemberMapper {
	static public Member toDomain(MemberEntity entity) {
		return new Member(
			entity.getId(),
			entity.getName(),
			entity.getEmail(),
			entity.getPassword(),
			entity.getCreatedAt(),
			entity.getUpdatedAt(),
			entity.getDeletedAt()
		);
	}

	static public MemberEntity toEntity(Member domain) {
		return MemberEntity.builder()
			.id(domain.id())
			.name(domain.name())
			.email(domain.email())
			.password(domain.password())
			.createdAt(domain.createdAt())
			.updatedAt(domain.updatedAt())
			.deletedAt(domain.deletedAt())
			.build();
	}
}
