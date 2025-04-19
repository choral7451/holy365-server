package goj.holy365.common.dto.response;

import goj.holy365.common.enums.ApiErrorType;
import goj.holy365.common.enums.ApiResultType;
import goj.holy365.common.exception.ExceptionMessage;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApiResponse<T> {

	@Schema(description = "결과 타입", example = "FAIL")
	private ApiResultType type;

	private ExceptionMessage exception;

	private T data;

	public static <T> ApiResponse<T> success(T data) {
		return new ApiResponse<>(ApiResultType.SUCCESS, null, data);
	}

	public static <T> ApiResponse<T> fail(ApiErrorType errorType) {
		return new ApiResponse<>(ApiResultType.FAIL, new ExceptionMessage(errorType), null);
	}

	public ApiResponse(ApiResultType resultType, ExceptionMessage exception, T data) {
		this.type = resultType;
		this.exception = exception;
		this.data = data;
	}
}
