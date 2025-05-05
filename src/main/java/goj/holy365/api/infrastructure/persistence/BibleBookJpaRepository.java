package goj.holy365.api.infrastructure.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import goj.holy365.api.infrastructure.entity.BibleBookEntity;

public interface BibleBookJpaRepository extends JpaRepository<BibleBookEntity, Long> {
	List<BibleBookEntity> findAllByOrderByOrderIndexAsc();
}
