package com.foodtruck.finder;

import java.util.Arrays;
import java.util.List;

import org.apache.http.client.utils.URIBuilder;
import org.joda.time.DateTime;

import lombok.Data;
import lombok.SneakyThrows;

public class FoodTruckRepository {

	// dayorder=x start24=x end24=x limit=x offset=x
	private static final String ALL_FOOD_TRUCKS = "http://data.sfgov.org/resource/bbb8-hzi6.json";

	@SneakyThrows
	public static FoodTrucks getOpenFoodTrucks(DateTime dateTime, Integer pageNumber, Integer resultsPerPage) {

		URIBuilder builder = new URIBuilder(ALL_FOOD_TRUCKS);

		builder.addParameter("dayorder", dateTime.getDayOfWeek() + "");
		builder.addParameter("$limit", resultsPerPage.toString());
		builder.addParameter("$offset", pageNumber.toString());
		builder.addParameter("$where", getHourOfDayQuery(dateTime));

		String url = builder.build().toString();

		List<FoodTruckResponse> responses = Arrays.asList(RestRepository.getForObject(url, FoodTruckResponse[].class));

		return FoodTruckFactory.build(responses);
	}

	// business methods

	private static String getHourOfDayQuery(DateTime dateTime) {
		String hourOfDay = getFormattedHourOfDay(dateTime.getHourOfDay());
		return "start24<=\"" + hourOfDay + "\" and end24>\"" + hourOfDay + "\"";
	}

	private static String getFormattedHourOfDay(Integer hourOfDay) {
		String hourOfDayString = "";

		if (hourOfDay < 10) {
			hourOfDayString += "0";
		}

		return hourOfDayString + hourOfDay + ":00";
	}

	// static classes

	@Data
	public static class FoodTruckResponse {
		private String location;
		private String applicant;
	}
}
