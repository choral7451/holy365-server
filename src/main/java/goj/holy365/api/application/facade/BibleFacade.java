package goj.holy365.api.application.facade;

import java.util.List;

import org.springframework.stereotype.Component;

import goj.holy365.api.application.facade.dto.in.ScanVersesFacadeDto;
import goj.holy365.api.application.facade.dto.out.BibleBookInfo;
import goj.holy365.api.application.facade.dto.out.BibleVerseInfo;
import goj.holy365.api.domain.service.BibleService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BibleFacade {
	private final BibleService bibleService;

	public List<BibleVerseInfo> scanVerses(ScanVersesFacadeDto dto) {
		return bibleService.scanVerses(dto.toServiceDto())
			.stream()
			.map(verse -> new BibleVerseInfo(
				verse.chapter(),
				verse.verse(),
				verse.content()
			))
			.toList();
	}

	public List<Integer> scanChapters(Long versionId, Long bookId) {
		return bibleService.scanChapters(versionId, bookId);
	}

	public List<BibleBookInfo> scanBooks(Long versionId) {
		return bibleService.scanBooks(versionId)
			.stream()
			.map(book -> new BibleBookInfo(
				book.testament(),
				book.nameKo(),
				book.nameEn(),
				book.orderIndex()
			))
			.toList();
	}
}
