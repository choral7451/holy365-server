package com.holy365.api.domain;

import com.holy365.api.domain.enums.AuthType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

  @Column(name = "nickname")
  private String nickname;

  @Column(name = "email")
  private String email;

  @OneToOne(mappedBy = "user",cascade = CascadeType.REMOVE)
  private Auth auth;

  @Builder
  public User(String name, String nickname, String email) {
    this.name = name;
    this.nickname = nickname;
    this.email = email;
  }
}
