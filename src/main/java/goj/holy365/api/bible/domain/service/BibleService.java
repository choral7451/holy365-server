package goj.holy365.api.bible.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goj.holy365.api.bible.domain.interfaces.BibleVerseRepository;
import goj.holy365.api.bible.domain.service.dto.in.ScanVersesServiceDto;
import goj.holy365.api.bible.domain.service.dto.out.BibleVerseInfo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BibleService {
	private final BibleVerseRepository bibleVerseRepository;

	@Transactional
	public List<BibleVerseInfo> scanVerses(ScanVersesServiceDto dto) {
		return bibleVerseRepository.scanVerses(dto.versionId(), dto.bookId())
			.stream()
			.map(entity -> new BibleVerseInfo(
				entity.getChapter(),
				entity.getVerse(),
				entity.getContent()
			))
			.toList();
	}
}
