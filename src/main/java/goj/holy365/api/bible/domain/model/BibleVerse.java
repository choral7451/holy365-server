package goj.holy365.api.bible.domain.model;

import java.time.LocalDateTime;

public class BibleVerse {
	private final Long id;
	private final BibleVersion version;
	private final BibleBook book;
	private final Integer chapter;
	private final Integer verse;
	private final String content;
	private final LocalDateTime createdAt;
	private final LocalDateTime updatedAt;
	private final LocalDateTime deletedAt;

	public BibleVerse(Long id, BibleVersion version, BibleBook book, Integer chapter, Integer verse, String content,
		LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
		this.id = id;
		this.version = version;
		this.book = book;
		this.chapter = chapter;
		this.verse = verse;
		this.content = content;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	public Long getId() {
		return id;
	}

	public BibleVersion getVersion() {
		return version;
	}

	public BibleBook getBook() {
		return book;
	}

	public Integer getChapter() {
		return chapter;
	}

	public Integer getVerse() {
		return verse;
	}

	public String getContent() {
		return content;
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
