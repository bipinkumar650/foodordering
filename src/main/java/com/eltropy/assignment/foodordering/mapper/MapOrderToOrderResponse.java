package com.eltropy.assignment.foodordering.mapper;

import com.eltropy.assignment.foodordering.model.Item;
import com.eltropy.assignment.foodordering.model.Order;
import com.eltropy.assignment.foodordering.model.OrderResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MapOrderToOrderResponse {
  public OrderResponseDTO map(Order order) {
    return new OrderResponseDTO(
        order.getId(),
        order.getItems().stream().map(Item::getName).collect(Collectors.toList()),
        order.getPrice(),
        order.getUserId()
    );
  }
}
