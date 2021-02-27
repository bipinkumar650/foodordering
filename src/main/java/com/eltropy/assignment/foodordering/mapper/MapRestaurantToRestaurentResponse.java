package com.eltropy.assignment.foodordering.mapper;

import com.eltropy.assignment.foodordering.model.Restaurant;
import com.eltropy.assignment.foodordering.model.RestaurentResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class MapRestaurantToRestaurentResponse {
  public RestaurentResponseDTO map(Restaurant restaurant) {
    return new RestaurentResponseDTO(restaurant.getRestaurantId(), restaurant.getName(), restaurant.getAddress());
  }
}
