package com.holy365.api.exception;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class Holy365Exception extends RuntimeException {
  public final Map<String, String> validation = new HashMap<>();

  public Holy365Exception(String message) {
    super(message);
  }

  public Holy365Exception(String message, Throwable cause) {
    super(message, cause);
  }

  public abstract int getStatusCode();

  public void addValidation(String fieldName, String message) {
    validation.put(fieldName, message);
  }
}