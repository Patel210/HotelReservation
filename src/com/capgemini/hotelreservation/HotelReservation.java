package com.capgemini.hotelreservation;

import java.util.HashMap;
import java.util.Map;

public class HotelReservation {

	private Map<String, Hotel> availableHotels = new HashMap<String, Hotel>();

	public HotelReservation() {
		super();
	}

	/**
	 * @param hotelName
	 * @param weekdayRate
	 * @param weekendRate
	 *  Add Hotel in the system
	 */
	public void addHotelToSystem(String hotelName, Integer weekdayRate, Integer weekendRate) {
		Hotel hotel = new Hotel(hotelName, weekdayRate, weekendRate);
		availableHotels.put(hotelName, hotel);
		System.out.println("Hotel added  successfully!");
	}
}
