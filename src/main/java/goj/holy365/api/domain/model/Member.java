package goj.holy365.api.domain.model;

import java.time.LocalDateTime;

public record Member(
	Long id,
	String name,
	String email,
	String password,
	LocalDateTime createdAt,
	LocalDateTime updatedAt,
	LocalDateTime deletedAt
) {
}
