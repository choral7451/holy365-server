package com.holy365.api.domain;

import com.holy365.api.domain.enums.AuthType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "auths")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Auth {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "identity", nullable = false)
  private String identity;


  @Column(name = "type", nullable = false)
  @Enumerated(EnumType.STRING)
  private AuthType type;

  @Column(name = "password")
  private String password;

  @LastModifiedDate
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @CreatedDate
  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "users_id", nullable = false)
  private User user;

  @Builder
  public Auth(String identity, String password, AuthType type, User user) {
    this.identity = identity;
    this.password = password;
    this.type = type;
    this.user = user;
  }
}
