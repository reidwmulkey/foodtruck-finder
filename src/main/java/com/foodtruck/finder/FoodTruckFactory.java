package com.foodtruck.finder;

import java.util.ArrayList;
import java.util.List;

import com.foodtruck.finder.FoodTruckRepository.FoodTruckResponse;

public class FoodTruckFactory {

	public static FoodTrucks build(List<FoodTruckResponse> responses) {

		List<FoodTruck> foodTrucks = new ArrayList<>();

		responses.forEach(response -> {
			foodTrucks.add(build(response));
		});

		return new FoodTrucks(foodTrucks);
	}

	public static FoodTruck build(FoodTruckResponse response) {

		FoodTruck foodTruck = new FoodTruck();

		foodTruck.setName(response.getApplicant());
		foodTruck.setAddress(response.getLocation());

		return foodTruck;
	}
}
