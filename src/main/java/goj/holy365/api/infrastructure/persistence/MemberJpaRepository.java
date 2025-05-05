package goj.holy365.api.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import goj.holy365.api.infrastructure.entity.MemberEntity;

public interface MemberJpaRepository extends JpaRepository<MemberEntity, Long> {
}
