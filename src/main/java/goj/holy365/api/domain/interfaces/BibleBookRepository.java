package goj.holy365.api.domain.interfaces;

import java.util.List;

import goj.holy365.api.domain.model.BibleBook;

public interface BibleBookRepository {
	List<BibleBook> scanBooks(Long versionId);
}
