package com.eltropy.assignment.foodordering.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RestaurentResponseDTO {
  private String restaurantId;
  private String name;
  private String address;

  public RestaurentResponseDTO(String restaurantId, String name, String address) {
    this.restaurantId = restaurantId;
    this.name = name;
    this.address = address;
  }

  public String getRestaurantId() {
    return restaurantId;
  }

  public void setRestaurantId(String restaurantId) {
    this.restaurantId = restaurantId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
