package goj.holy365.api.bible.interfaces.controller.dto.in;

import goj.holy365.api.bible.domain.service.dto.in.ScanVersesServiceDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScanBibleVersesRequest {
	@NotNull(message = "versionId 값을 입력해주세요.")
	@Schema(description = "성경 버전 ID", example = "1")
	Long versionId;

	@NotNull(message = "bookId 값을 입력해주세요.")
	@Schema(description = "성경 책 ID", example = "1")
	Long bookId;

	public ScanVersesServiceDto toServiceDto() {
		return new ScanVersesServiceDto(versionId, bookId);
	}
}
