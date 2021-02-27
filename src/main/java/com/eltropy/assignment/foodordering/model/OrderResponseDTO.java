package com.eltropy.assignment.foodordering.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderResponseDTO {
  String id;
  List<String> items;
  double price;
  String userId;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public List<String> getItems() {
    return items;
  }

  public void setItems(List<String> items) {
    this.items = items;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public OrderResponseDTO(String id, List<String> items, float price, String userId) {
    this.id = id;
    this.items = items;
    this.price = price;
    this.userId = userId;
  }
}
