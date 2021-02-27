package com.eltropy.assignment.foodordering.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
  String name;
  private List<String> recipe;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getRecipe() {
    return recipe;
  }

  public void setRecipe(List<String> recipe) {
    this.recipe = recipe;
  }

  public Item(String name, List<String> recipe) {
    this.name = name;
    this.recipe = recipe;
  }
}
