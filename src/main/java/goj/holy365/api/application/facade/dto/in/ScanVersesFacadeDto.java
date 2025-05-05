package goj.holy365.api.application.facade.dto.in;

import goj.holy365.api.domain.service.dto.in.ScanVersesServiceDto;

public record ScanVersesFacadeDto(
	Long versionId,
	Long bookId,
	Integer chapter
) {
	public ScanVersesServiceDto toServiceDto() {
		return new ScanVersesServiceDto(
			versionId(),
			bookId(),
			chapter()
		);
	}
}
