package goj.holy365.api.bible.domain.model;

import java.time.LocalDateTime;

public class BibleBook {
	private final Long id;
	private final String testament;
	private final String nameKo;
	private final String nameEn;
	private final Integer orderIndex;
	private final LocalDateTime createdAt;
	private final LocalDateTime updatedAt;
	private final LocalDateTime deletedAt;

	public BibleBook(Long id, String testament, String nameKo, String nameEn, Integer orderIndex, LocalDateTime createdAt,
		LocalDateTime updatedAt, LocalDateTime deletedAt) {
		this.id = id;
		this.testament = testament;
		this.nameKo = nameKo;
		this.nameEn = nameEn;
		this.orderIndex = orderIndex;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	public Long getId() {
		return id;
	}

	public String getTestament() {
		return testament;
	}

	public String getNameKo() {
		return nameKo;
	}

	public String getNameEn() {
		return nameEn;
	}

	public Integer getOrderIndex() {
		return orderIndex;
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
