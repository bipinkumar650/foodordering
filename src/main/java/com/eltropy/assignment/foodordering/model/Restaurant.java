package com.eltropy.assignment.foodordering.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "restaurant")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Restaurant {
  @Id
  private String restaurantId;
  private String name;
  private String address;
  private List<Item> menu;

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

  public String getRestaurantId() {
    return restaurantId;
  }

  public void setRestaurantId(String restaurantId) {
    this.restaurantId = restaurantId;
  }

  public List<Item> getMenu() {
    return this.menu;
  }

  public void setMenu(List<Item> menu) {
    this.menu = menu;
  }

}
