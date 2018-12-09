package com.foodtruck.finder;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class Main {
	public static void main(String[] args) {

		// convert now to the west coast time zone for determining what the
		// current time is in san fransisco
		DateTime now = new DateTime();
		DateTimeZone californiaTime = DateTimeZone.forID("America/Los_Angeles");
		now = now.withZone(californiaTime);

		FoodTrucks foodTrucks = FoodTruckRepository.getOpenFoodTrucks(now, 0, 10);

		System.out.println(foodTrucks.toString());

	}
}
