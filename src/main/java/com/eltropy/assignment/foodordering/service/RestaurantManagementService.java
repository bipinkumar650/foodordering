package com.eltropy.assignment.foodordering.service;

import com.eltropy.assignment.foodordering.exception.EntityNotFoundException;
import com.eltropy.assignment.foodordering.mapper.MapItemsToMenu;
import com.eltropy.assignment.foodordering.mapper.MapRestaurantToRestaurentResponse;
import com.eltropy.assignment.foodordering.model.Item;
import com.eltropy.assignment.foodordering.model.ItemResponseDTO;
import com.eltropy.assignment.foodordering.model.Restaurant;
import com.eltropy.assignment.foodordering.model.RestaurentResponseDTO;
import com.eltropy.assignment.foodordering.persistance.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantManagementService {
  private final RestaurantRepository restaurantRepository;
  private final MapRestaurantToRestaurentResponse mapRestaurantToRestaurentResponse;
  private final MapItemsToMenu mapItemsToMenu;

  public RestaurantManagementService(RestaurantRepository restaurantRepository, MapRestaurantToRestaurentResponse mapRestaurantToRestaurentResponse,
                                     MapItemsToMenu mapItemsToMenu) {
    this.restaurantRepository = restaurantRepository;
    this.mapRestaurantToRestaurentResponse = mapRestaurantToRestaurentResponse;
    this.mapItemsToMenu = mapItemsToMenu;
  }

  public List<RestaurentResponseDTO> getRestaurants() {
    List<RestaurentResponseDTO> list = new ArrayList<>();
    restaurantRepository.findAll().forEach(restaurant -> {
      list.add(mapRestaurantToRestaurentResponse.map(restaurant));
    });
    return list;
  }

  public List<ItemResponseDTO> getMenu(String restaurantId) {
    List<ItemResponseDTO> menu = new ArrayList<>();
    try {
      List<Item> itemList = restaurantRepository.findById(restaurantId).get().getMenu();
      itemList.forEach(item -> {
        menu.add(mapItemsToMenu.map(item));
      });
    } catch (Exception e) {
      throw new EntityNotFoundException("Please provide a valid restaurentId");
    }
    return menu;
  }

  public void registerRestaurant(Restaurant restaurant) {
    restaurantRepository.deleteAll();
    restaurantRepository.save(restaurant);
  }
}
