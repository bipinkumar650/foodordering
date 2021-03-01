package com.eltropy.assignment.foodordering.controller;

import com.eltropy.assignment.foodordering.model.User;
import com.eltropy.assignment.foodordering.service.OrderManagementService;
import com.eltropy.assignment.foodordering.service.TokengeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/driver")
public class DriverController {
  @Autowired
  OrderManagementService orderManagementService;

  @Autowired
  TokengeneratorService tokengeneratorService;

  @PostMapping("/deliverOrder")
  String deliverOrder() {
    return orderManagementService.deliverOrder();
  }

  @PostMapping("/login")
  public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) {

    String token = tokengeneratorService.getJWTToken(username);
    User user = new User();
    user.setUser(username);
    user.setToken(token);
    return user;
  }

}
