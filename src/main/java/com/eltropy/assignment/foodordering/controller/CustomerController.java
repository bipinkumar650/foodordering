package com.eltropy.assignment.foodordering.controller;

import com.eltropy.assignment.foodordering.model.Item;
import com.eltropy.assignment.foodordering.model.ItemResponseDTO;
import com.eltropy.assignment.foodordering.model.RestaurentResponseDTO;
import com.eltropy.assignment.foodordering.model.User;
import com.eltropy.assignment.foodordering.service.OrderManagementService;
import com.eltropy.assignment.foodordering.service.RestaurantManagementService;
import com.eltropy.assignment.foodordering.service.TokengeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
  @Autowired
  RestaurantManagementService restaurantManagementService;
  @Autowired
  TokengeneratorService tokengeneratorService;

  @Autowired
  OrderManagementService orderManagementService;

  @PostMapping("/login")
  public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) {

    String token = tokengeneratorService.getJWTToken(username);
    User user = new User();
    user.setUser(username);
    user.setToken(token);
    return user;
  }

  @GetMapping("/getRestaurants")
  List<RestaurentResponseDTO> getRestaurants() {
    return restaurantManagementService.getRestaurants();
  }

  @GetMapping("/getMenu")
  List<ItemResponseDTO> getMenu(@RequestParam String restaurantId) {
    return restaurantManagementService.getMenu(restaurantId);
  }

  @PostMapping("/placeOrder")
  String placeOrder(@RequestParam String restaurantId, @RequestBody List<Item> items) {
    String orderId = orderManagementService.placeOrder(restaurantId, items);
    return String.format("Your order has been placed successfully, orderId is %s", orderId);
  }

  @PostMapping("/cancelOrder")
  Boolean cancelOrder(String orderId) {
    return orderManagementService.cancelOrder(orderId);
  }
}
