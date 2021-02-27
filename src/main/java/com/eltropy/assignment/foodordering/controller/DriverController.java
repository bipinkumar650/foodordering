package com.eltropy.assignment.foodordering.controller;

import com.eltropy.assignment.foodordering.service.OrderManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/driver")
public class DriverController {
  @Autowired
  OrderManagementService orderManagementService;

  @PostMapping("/deliverOrder")
  String deliverOrder() {
    return orderManagementService.deliverOrder();
  }

}
