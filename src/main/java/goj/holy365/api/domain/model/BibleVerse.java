package goj.holy365.api.domain.model;

import java.time.LocalDateTime;

public record BibleVerse(
	Long id,
	BibleVersion version,
	BibleBook book,
	Integer chapter,
	Integer verse,
	String content,
	LocalDateTime createdAt,
	LocalDateTime updatedAt,
	LocalDateTime deletedAt
) {
}
