package goj.holy365.api.domain.model;

import java.time.LocalDateTime;

public record BibleBook(
	Long id,
	String testament,
	String nameKo,
	String nameEn,
	Integer orderIndex,
	LocalDateTime createdAt,
	LocalDateTime updatedAt,
	LocalDateTime deletedAt
) {
}
