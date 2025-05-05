package goj.holy365.common.enums;

import org.springframework.boot.logging.LogLevel;

import lombok.Getter;

@Getter
public enum ApiErrorType {
	// system
	INTERNAL_SERVER_ERROR(ApiErrorCode.SERVER_ERROR, "SYSTEM-1", "서버에서 오류가 발생했습니다. 요청을 처리할 수 없습니다.", LogLevel.ERROR),
	BAD_REQUEST(ApiErrorCode.CLIENT_ERROR, "E000002", "유효하지 않은 요청입니다.", LogLevel.WARN),

	// MEMBER
	INVALID_PASSWORD(ApiErrorCode.CLIENT_ERROR, "MEMBER-1", "비밀번호는 최소 8자 이상이며, 영문자, 숫자, 특수문자를 각각 하나 이상 포함해야 합니다.",
		LogLevel.WARN);

	private final ApiErrorCode errorCode;
	private final String errorNo;
	private final String message;
	private final LogLevel logLevel;

	ApiErrorType(ApiErrorCode errorCode, String errorNo, String message, LogLevel logLevel) {
		this.errorCode = errorCode;
		this.errorNo = errorNo;
		this.message = message;
		this.logLevel = logLevel;
	}
}
