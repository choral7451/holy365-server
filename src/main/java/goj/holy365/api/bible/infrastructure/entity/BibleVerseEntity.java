package goj.holy365.api.bible.infrastructure.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
@SQLDelete(sql = "UPDATE bible_verse SET deleted_at = NOW() WHERE id = ?")
@SQLRestriction("deleted_at is NULL")
@Table(name = "bible_verse")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BibleVerseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private BibleVersionEntity version;

	@ManyToOne(fetch = FetchType.LAZY)
	private BibleBookEntity book;

	@Column(name = "chapter", nullable = false)
	private Integer chapter;

	@Column(name = "verse", nullable = false)
	private Integer verse;

	@Column(name = "content", nullable = false)
	private String content;

	@CreatedDate
	@Column(name = "created_at", updatable = false, nullable = false)
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;

	@Column(name = "deleted_At")
	private LocalDateTime deletedAt;

	@Builder
	public BibleVerseEntity(Long id, BibleVersionEntity version, BibleBookEntity book, Integer chapter, Integer verse,
		String content, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
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
}
