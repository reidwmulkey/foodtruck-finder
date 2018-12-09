package com.foodtruck.finder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FoodTruck {

	private String address;
	private String name;

	public String toString(){
		return name + "\t" + address;
	}
}
