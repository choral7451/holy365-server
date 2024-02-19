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
@Table(name = "bible_status_title")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BibleStatusTitle {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "title", nullable = false)
  private String title;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @CreatedDate
  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Builder
  public BibleStatusTitle(String title, User user) {
    this.title = title;
    this.user = user;
  }
}
