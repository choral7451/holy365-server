package goj.holy365.api.application.facade.dto.out;

public record BibleVerseInfo(
	Integer chapter,
	Integer verse,
	String content
) {
}
