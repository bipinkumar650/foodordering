package com.eltropy.assignment.foodordering.controller;


import com.eltropy.assignment.foodordering.model.Order;
import com.eltropy.assignment.foodordering.model.OrderResponseDTO;
import com.eltropy.assignment.foodordering.model.User;
import com.eltropy.assignment.foodordering.service.OrderManagementService;
import com.eltropy.assignment.foodordering.service.TokengeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

  @Autowired
  OrderManagementService orderManagementService;
  @Autowired
  TokengeneratorService tokengeneratorService;

  @PostMapping("/login")
  public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) {

    String token = tokengeneratorService.getJWTToken(username);
    User user = new User();
    user.setUser(username);
    user.setToken(token);
    return user;
  }

  @GetMapping("/getOrders")
  List<OrderResponseDTO> getOrders(@RequestParam String restaurantId) {
    List<OrderResponseDTO> orders = orderManagementService.getOrders(restaurantId);
    orders.forEach(order -> {
      orderManagementService.updateOrderStatus(order);
    });
    return orders;
  }
}
