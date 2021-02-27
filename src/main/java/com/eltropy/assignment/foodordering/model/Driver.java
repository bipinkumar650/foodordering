package com.eltropy.assignment.foodordering.model;

import com.eltropy.assignment.foodordering.model.Order;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "driver")
public class Driver{
  @Id
  private String driverId;
  private String name;
  private String address;

  public void updateOrderStatus(Order order) {

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

  public String getDriverId() {
    return driverId;
  }

  public void setDriverId(String driverId) {
    this.driverId = driverId;
  }
}
