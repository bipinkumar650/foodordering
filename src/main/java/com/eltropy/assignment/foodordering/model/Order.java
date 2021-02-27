package com.eltropy.assignment.foodordering.model;

import com.eltropy.assignment.foodordering.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "order")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {
  @Id
  String id;
  OrderStatus status;
  List<Item> items;
  float price;
  String restaurantId;
  String userId;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public String getRestaurantId() {
    return restaurantId;
  }

  public void setRestaurantId(String restaurantId) {
    this.restaurantId = restaurantId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public Order(String id, OrderStatus status, List<Item> items, float price, String restaurantId, String userId) {
    this.id = id;
    this.status = status;
    this.items = items;
    this.price = price;
    this.restaurantId = restaurantId;
    this.userId = userId;
  }
}
