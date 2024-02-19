package com.holy365.api.exception;

public class BibleNotFound extends Holy365Exception {
  private static final String MESSAGE = "해당 성경이 존재하지 않습니다.";

  public BibleNotFound() {
    super(MESSAGE);
  }

  @Override
  public int getStatusCode() {
    return 404;
  }
}
