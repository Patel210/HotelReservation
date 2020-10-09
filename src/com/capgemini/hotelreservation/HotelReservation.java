package com.capgemini.hotelreservation;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class HotelReservation {

	private Map<String, Hotel> availableHotels = new HashMap<String, Hotel>();

	public HotelReservation() {
		super();
	}

	/**
	 * @param hotelName
	 * @param regularRates Add Hotel in the system
	 */
	public void addHotelToSystem(String hotelName, int regularRates) {
		Hotel hotel = new Hotel(hotelName, regularRates);
		availableHotels.put(hotelName, hotel);
	}

	/**
	 * @param startDate
	 * @param endDate
	 * @throws ParseException Shows the cheapest Hotel/Hotels if present
	 */
	public void findCheapestHotel(String startDate, String endDate) throws ParseException {

		LocalDate endDateOfReservation = null, startDateOfReservation = null;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMMyyyy");
		startDateOfReservation = LocalDate.parse(startDate, dtf);
		endDateOfReservation = LocalDate.parse(endDate, dtf);
		int noOfDays = (int) ChronoUnit.DAYS.between(startDateOfReservation, endDateOfReservation);

		Function<Hotel, Integer> toGetRates = hotel -> hotel.getRegularRate() * noOfDays;
		if (availableHotels.size() != 0) {
			int cheapestRate = availableHotels.entrySet().stream().map(entry -> toGetRates.apply(entry.getValue()))
					.min((i, j) -> i.compareTo(j)).get();

			availableHotels.entrySet().stream().filter(entry -> toGetRates.apply(entry.getValue()) == cheapestRate)
					.forEach(entry -> System.out
							.println("Cheapest Hotel: " + entry.getKey() + ", Total rates: " + cheapestRate));
		} else {
			System.out.println("Sorry! No Hotel is available in the system");
		}
	}
}
