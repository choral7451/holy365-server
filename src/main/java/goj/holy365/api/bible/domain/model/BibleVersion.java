package goj.holy365.api.bible.domain.model;

import java.time.LocalDateTime;

public class BibleVersion {
	private final Long id;
	private final String code;
	private final String nameKo;
	private final String nameEn;
	private final LocalDateTime createdAt;
	private final LocalDateTime updatedAt;
	private final LocalDateTime deletedAt;

	public BibleVersion(Long id, String code, String nameKo, String nameEn, LocalDateTime createdAt,
		LocalDateTime updatedAt, LocalDateTime deletedAt) {
		this.id = id;
		this.code = code;
		this.nameKo = nameKo;
		this.nameEn = nameEn;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	public Long getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public String getNameKo() {
		return nameKo;
	}

	public String getNameEn() {
		return nameEn;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public LocalDateTime getDeletedAt() {
		return deletedAt;
	}
}
