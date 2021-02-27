package com.eltropy.assignment.foodordering.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
  @ExceptionHandler
  public ResponseEntity<?> restaurentNotFound(EntityNotFoundException ex) {
    return ResponseEntity.badRequest().body(new ResponseStatusError(404, ex.getMessage()));
  }
}
