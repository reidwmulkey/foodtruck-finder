package com.foodtruck.finder;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodTrucks {

	private List<FoodTruck> foodTrucks = new ArrayList<>();

	// business methods

	private int getLengthOfLongestName() {
		// 4 because NAME will be the title up at the top of the printout, but
		// out of 10 random businesses, at least one likely has a name longer
		// than 4 characters
		return Math.max(4, foodTrucks.stream().map(ft -> ft.getName()).sorted((a, b) -> b.length() - a.length())
				.findFirst().orElse("").length());
	}

	// using spaces instead of tabs because tabs are user
	// configurable and are either 4 or 8 and I didn't want that to
	// be the reason it prints out weird when runing
	private String padWithSpacesToLength(String s, Integer length) {
		String paddedString = s;

		while (paddedString.length() <= length) {
			paddedString += " ";
		}

		return paddedString;
	}

	public String toString() {

		int lengthToPad = getLengthOfLongestName();

		String result = padWithSpacesToLength("NAME", lengthToPad) + "ADDRESS\n";

		for (FoodTruck foodTruck : foodTrucks) {
			result += padWithSpacesToLength(foodTruck.getName(), lengthToPad) + foodTruck.getAddress() + "\n";
		}

		return result;
	}
}
