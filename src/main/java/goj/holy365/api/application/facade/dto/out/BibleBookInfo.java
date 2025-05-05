package goj.holy365.api.application.facade.dto.out;

public record BibleBookInfo(
	String testament,
	String nameKo,
	String nameEn,
	Integer orderIndex
) {
}
