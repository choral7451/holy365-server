package goj.holy365.api.bible.interfaces.controller.dto.in;

import goj.holy365.api.bible.domain.service.dto.in.ScanVersesServiceDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScanBibleVersesRequest {
	@Schema(description = "성경 버전 ID", example = "1")
	Long versionId;

	@Schema(description = "성경 책 ID", example = "1")
	Long bookId;

	public ScanVersesServiceDto toServiceDto() {
		return new ScanVersesServiceDto(versionId, bookId);
	}
}
