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
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
@SQLDelete(sql = "UPDATE bible_book SET deleted_at = NOW() WHERE id = ?")
@SQLRestriction("deleted_at is NULL")
@Table(name = "bible_book")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BibleBookEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "testament", nullable = false)
	private String testament;

	@Column(name = "name_ko", nullable = false)
	private String nameKo;

	@Column(name = "name_en", nullable = false)
	private String nameEn;

	@Column(name = "order_index", nullable = false)
	private Integer orderIndex;

	@CreatedDate
	@Column(name = "created_at", updatable = false, nullable = false)
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;

	@Column(name = "deleted_At")
	private LocalDateTime deletedAt;

	@Builder
	public BibleBookEntity(Long id, String testament, String nameKo, String nameEn, Integer orderIndex,
		LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
		this.id = id;
		this.testament = testament;
		this.nameKo = nameKo;
		this.nameEn = nameEn;
		this.orderIndex = orderIndex;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}
}