package goj.holy365.api.bible.domain.interfaces;

import java.util.List;

import goj.holy365.api.bible.domain.model.BibleVerse;

public interface BibleVerseRepository {
	List<BibleVerse> scanVerses(Long versionId, Long bookId);
}
