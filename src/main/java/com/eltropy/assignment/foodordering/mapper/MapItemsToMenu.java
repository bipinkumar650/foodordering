package com.eltropy.assignment.foodordering.mapper;

import com.eltropy.assignment.foodordering.model.Item;
import com.eltropy.assignment.foodordering.model.ItemResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class MapItemsToMenu {
  public ItemResponseDTO map(Item item) {
    return new ItemResponseDTO(item.getName(), item.getRecipe().size()*5);
  }
}
