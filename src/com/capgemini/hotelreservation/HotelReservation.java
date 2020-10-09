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
	 * @param regularRates Add Hotel in the system
	 */
	public void addHotelToSystem(String hotelName, int regularRates) {
		Hotel hotel = new Hotel(hotelName, regularRates);
		availableHotels.put(hotelName, hotel);
	}

}
