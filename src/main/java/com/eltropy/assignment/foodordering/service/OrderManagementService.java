package com.eltropy.assignment.foodordering.service;

import com.eltropy.assignment.foodordering.enums.OrderStatus;
import com.eltropy.assignment.foodordering.exception.EntityNotFoundException;
import com.eltropy.assignment.foodordering.mapper.MapOrderToOrderResponse;
import com.eltropy.assignment.foodordering.model.Item;
import com.eltropy.assignment.foodordering.model.Order;
import com.eltropy.assignment.foodordering.model.OrderResponseDTO;
import com.eltropy.assignment.foodordering.persistance.OrderRepository;
import com.eltropy.assignment.foodordering.persistance.RestaurantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderManagementService {
  Logger logger = LoggerFactory.getLogger(OrderManagementService.class);
  private final OrderRepository orderRepository;
  private final MapOrderToOrderResponse mapOrderToOrderResponse;
  private final RestaurantRepository restaurantRepository;

  public OrderManagementService(OrderRepository orderRepository, MapOrderToOrderResponse mapOrderToOrderResponse,
                                RestaurantRepository restaurantRepository) {
    this.orderRepository = orderRepository;
    this.mapOrderToOrderResponse = mapOrderToOrderResponse;
    this.restaurantRepository = restaurantRepository;
  }

  public String placeOrder(String restaurantId, List<Item> items) {
    if (restaurantRepository.findById(restaurantId).isEmpty()) throw new EntityNotFoundException("Please provide a valid restaurentId");
    String orderId = UUID.randomUUID().toString();
    Order order = new Order(orderId, OrderStatus.RECEIVED, items, items.size()*5, restaurantId, "user1");
    orderRepository.save(order);
    logger.info("Order placed successfully");
    return orderId;
  }

  public Boolean cancelOrder(String orderId) {
    try {
      Order order = orderRepository.findById(orderId).get();
      if (order.getStatus() == OrderStatus.RECEIVED) {
        order.setStatus(OrderStatus.CANCELED);
        orderRepository.save(order);
        logger.info("Your Order has been cancelled");
        return true;
      }
    } catch (Exception e) {
      throw new EntityNotFoundException("Please provide a valid orderId");
    }
    return false;
  }

  public List<OrderResponseDTO> getOrders(String restaurantId) {
    List<OrderResponseDTO> list = new ArrayList<>();
    List<Order> orders = orderRepository.findByRestaurantId(restaurantId);
    orders.forEach(order -> list.add(mapOrderToOrderResponse.map(order)));
    return list;
  }

  public void updateOrderStatus(OrderResponseDTO order) {
    if (orderRepository.findById(order.getId()).isPresent()) {
      Order ord = orderRepository.findById(order.getId()).get();
      ord.setStatus(OrderStatus.COMPLETED);
      orderRepository.save(ord);
    }
  }

  public String deliverOrder() {
    List<Order> orders = orderRepository.findByStatus(OrderStatus.COMPLETED);
    if (orders.size() > 0) {
      Order orderToDeliver = orders.get(0);
      orderToDeliver.setStatus(OrderStatus.COMPLETED);
      orderRepository.save(orderToDeliver);
      return "Order delivered successfully";
    }
    return "No orders to deliver at this moment";
  }

}
