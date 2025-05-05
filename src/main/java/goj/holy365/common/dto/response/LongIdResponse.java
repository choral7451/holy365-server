package goj.holy365.common.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record LongIdResponse(
	@Schema(description = "ID", example = "1")
	Long id
) {
}
