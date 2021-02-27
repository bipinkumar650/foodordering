package com.eltropy.assignment.foodordering.exception;

public class EntityNotFoundException extends RuntimeException{
  public EntityNotFoundException(String message) {
    super(message);
  }
}
