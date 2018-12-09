package com.foodtruck.finder;

import org.joda.time.DateTime;

public class Main {
	public static void main(String[] args) {

		FoodTrucks foodTrucks = FoodTruckRepository.getOpenFoodTrucks(new DateTime(), 0, 10);
	
		System.out.println(foodTrucks.toString());
		
	}
}
