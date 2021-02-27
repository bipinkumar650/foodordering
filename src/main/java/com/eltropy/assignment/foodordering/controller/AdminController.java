package com.eltropy.assignment.foodordering.controller;

import com.eltropy.assignment.foodordering.model.Item;
import com.eltropy.assignment.foodordering.model.Restaurant;
import com.eltropy.assignment.foodordering.service.RestaurantManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

  @Autowired
  RestaurantManagementService restaurantManagementService;

  @PostMapping("/initializeData")
  boolean addDummyData() {
    List<Item> items1 = Arrays.asList(
        new Item("biryani", Arrays.asList("rice", "chicken", "masala")),
        new Item("naan", Arrays.asList("wheat", "butter"))
    );
    Restaurant restaurant1 = new Restaurant();
    restaurant1.setName("Karavalli");
    restaurant1.setAddress("Vivanta Bengaluru, Residency Road");
    restaurant1.setMenu(items1);
    restaurant1.setRestaurantId("1");
    restaurantManagementService.registerRestaurant(restaurant1);
    return true;
  }
}
