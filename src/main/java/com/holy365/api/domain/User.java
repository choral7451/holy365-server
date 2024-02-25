package com.holy365.api.domain;

import com.holy365.api.domain.bible.BibleStatusChapter;
import com.holy365.api.domain.bible.BibleStatusTitle;
import com.holy365.api.domain.bible.BibleStatusVerse;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Table(name = "profiles")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "nickname", unique=true)
  private String nickname;

  @Column(name = "email", unique=true)
  private String email;

  @OneToOne(mappedBy = "user",cascade = CascadeType.REMOVE)
  private Auth auth;

  @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
  private List<BibleStatusTitle> bibleStatusTitles;

  @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
  private List<BibleStatusChapter> bibleStatusChapters;

  @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
  private List<BibleStatusVerse> bibleStatusVerses;

  @LastModifiedDate
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @CreatedDate
  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Builder
  public User(String name, String nickname, String email) {
    this.name = name;
    this.nickname = nickname;
    this.email = email;
  }
}
