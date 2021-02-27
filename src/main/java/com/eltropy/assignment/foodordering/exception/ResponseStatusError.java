package com.eltropy.assignment.foodordering.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class ResponseStatusError {

  @JsonProperty("status_code")
  private int status;

  @JsonProperty("status_message")
  private String message;
}