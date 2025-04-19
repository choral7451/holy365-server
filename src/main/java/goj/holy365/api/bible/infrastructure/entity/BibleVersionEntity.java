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
@SQLDelete(sql = "UPDATE bible_version SET deleted_at = NOW() WHERE id = ?")
@SQLRestriction("deleted_at is NULL")
@Table(name = "bible_version")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BibleVersionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "code", nullable = false)
	private String code;

	@Column(name = "name_ko", nullable = false)
	private String nameKo;

	@Column(name = "name_en", nullable = false)
	private String nameEn;

	@CreatedDate
	@Column(name = "created_at", updatable = false, nullable = false)
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;

	@Column(name = "deleted_At")
	private LocalDateTime deletedAt;

	@Builder
	public BibleVersionEntity(Long id, String code, String nameKo, String nameEn, LocalDateTime createdAt,
		LocalDateTime updatedAt, LocalDateTime deletedAt) {
		this.id = id;
		this.code = code;
		this.nameKo = nameKo;
		this.nameEn = nameEn;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}
}
