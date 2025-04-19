package goj.holy365.common.exception;

import goj.holy365.common.enums.ApiErrorType;
import lombok.Getter;

@Getter
public class CoreException extends RuntimeException {
	private final ApiErrorType errorType;

	public CoreException(ApiErrorType errorType) {
		super(errorType.getMessage());
		this.errorType = errorType;
	}

	public ApiErrorType getErrorType() {
		return errorType;
	}

}