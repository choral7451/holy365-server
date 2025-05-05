package goj.holy365.api.interfaces.controller.dto.in;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScanBibleBooksRequest {
	@NotNull(message = "versionId 값을 입력해주세요.")
	@Schema(description = "성경 버전 ID", example = "1")
	Long versionId;

}
