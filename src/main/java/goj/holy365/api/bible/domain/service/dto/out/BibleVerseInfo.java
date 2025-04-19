package goj.holy365.api.bible.domain.service.dto.out;

public record BibleVerseInfo(
	Integer chapter,
	Integer verse,
	String content
) {
}
