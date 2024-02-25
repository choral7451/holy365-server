package com.holy365.api.domain.bible;

import com.holy365.api.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "bible_status_chapter")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BibleStatusChapter {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "en_title", nullable = false)
  private String enTitle;

  @Column(name = "chapter", nullable = false)
  private Integer chapter;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @CreatedDate
  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Builder
  public BibleStatusChapter(String enTitle, Integer chapter, User user) {
    this.enTitle = enTitle;
    this.chapter = chapter;
    this.user = user;
  }
}
