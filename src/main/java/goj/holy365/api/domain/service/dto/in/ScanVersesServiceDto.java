package goj.holy365.api.domain.service.dto.in;

public record ScanVersesServiceDto(
	Long versionId,
	Long bookId,
	Integer chapter
) {
}
