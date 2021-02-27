package com.eltropy.assignment.foodordering.persistance;

import com.eltropy.assignment.foodordering.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, String> {
}
