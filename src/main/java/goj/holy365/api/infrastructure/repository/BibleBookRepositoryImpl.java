package goj.holy365.api.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import goj.holy365.api.domain.interfaces.BibleBookRepository;
import goj.holy365.api.domain.model.BibleBook;
import goj.holy365.api.infrastructure.entity.BibleBookEntity;
import goj.holy365.api.infrastructure.mapper.BibleBookMapper;
import goj.holy365.api.infrastructure.persistence.BibleBookJpaRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BibleBookRepositoryImpl implements BibleBookRepository {
	private final BibleBookJpaRepository bibleBookJpaRepository;

	public List<BibleBook> scanBooks(Long versionId) {
		List<BibleBookEntity> entities = this.bibleBookJpaRepository.findAllByOrderByOrderIndexAsc();
		return entities.stream().map(BibleBookMapper::toDomain).toList();
	}
}
