package goj.holy365.api.domain.model;

import java.time.LocalDateTime;

public record BibleVersion(
	Long id,
	String code,
	String nameKo,
	String nameEn,
	LocalDateTime createdAt,
	LocalDateTime updatedAt,
	LocalDateTime deletedAt
) {
}
