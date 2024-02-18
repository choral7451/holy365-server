package com.holy365.api.exception;

public class LoginException extends Holy365Exception {

  private static final String MESSAGE = "아이디와 비밀번호가 일치하지 않습니다.";

  public LoginException() {
    super(MESSAGE);
  }

  public int getStatusCode() {
    return 400;
  }
}
