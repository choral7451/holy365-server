package goj.holy365.api.domain.interfaces;

import java.util.List;

import goj.holy365.api.domain.model.BibleVerse;

public interface BibleVerseRepository {
	List<BibleVerse> scanVerses(Long versionId, Long bookId, Integer chapter);

	List<Integer> scanChapters(Long versionId, Long bookId);
}
