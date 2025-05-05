package goj.holy365.api.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goj.holy365.api.domain.interfaces.BibleBookRepository;
import goj.holy365.api.domain.interfaces.BibleVerseRepository;
import goj.holy365.api.domain.model.BibleBook;
import goj.holy365.api.domain.model.BibleVerse;
import goj.holy365.api.domain.service.dto.in.ScanVersesServiceDto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BibleService {
	private final BibleVerseRepository bibleVerseRepository;
	private final BibleBookRepository bibleBookRepository;

	@Transactional
	public List<BibleVerse> scanVerses(ScanVersesServiceDto dto) {
		return bibleVerseRepository.scanVerses(dto.versionId(), dto.bookId(), dto.chapter());
	}

	public List<Integer> scanChapters(Long versionId, Long bookId) {
		return bibleVerseRepository.scanChapters(versionId, bookId);
	}

	public List<BibleBook> scanBooks(Long versionId) {
		return bibleBookRepository.scanBooks(versionId);
	}
}
