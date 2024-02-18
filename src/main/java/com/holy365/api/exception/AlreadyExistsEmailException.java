package com.holy365.api.exception;

public class AlreadyExistsEmailException extends Holy365Exception {

  private static final String MESSAGE = "이미 가입된 이메일입니다.";

  public AlreadyExistsEmailException() {
    super(MESSAGE);
  }

  public int getStatusCode() {
    return 400;
  }
}
