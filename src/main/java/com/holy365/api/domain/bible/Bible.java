package com.holy365.api.domain.bible;

import com.holy365.api.domain.enums.BibleCategory;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "bible")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Bible {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  private BibleCategory category;

  @Column(name = "ko_title")
  private String koTitle;

  @Column(name = "en_title")
  private String enTitle;
  private Integer chapter;
  private Integer verse;
  private String contents;
}
