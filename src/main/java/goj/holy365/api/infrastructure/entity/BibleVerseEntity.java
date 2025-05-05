package goj.holy365.api.infrastructure.entity;

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
import jakarta.persistence.JoinColumn;
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
	@JoinColumn(name = "version_id", insertable = false, updatable = false)
	private BibleVersionEntity version;

	@Column(name = "version_id", nullable = false)
	private Long versionId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id", insertable = false, updatable = false)
	private BibleBookEntity book;

	@Column(name = "book_id", nullable = false)
	private Long bookId;

	@Column(name = "chapter", nullable = false)
	private Integer chapter;

	@Column(name = "verse")
	private Integer verse;

	@Column(name = "content", nullable = false)
	private String content;

	@Column(name = "order_index", nullable = false)
	private Integer orderIndex;

	@CreatedDate
	@Column(name = "created_at", updatable = false, nullable = false)
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;

	@Column(name = "deleted_at")
	private LocalDateTime deletedAt;

	@Builder
	public BibleVerseEntity(Long id, BibleVersionEntity version, Long versionId, BibleBookEntity book, Long bookId,
		Integer chapter, Integer verse, String content, Integer orderIndex, LocalDateTime createdAt,
		LocalDateTime updatedAt,
		LocalDateTime deletedAt) {
		this.id = id;
		this.version = version;
		this.versionId = versionId;
		this.book = book;
		this.bookId = bookId;
		this.chapter = chapter;
		this.verse = verse;
		this.content = content;
		this.orderIndex = orderIndex;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}
}
