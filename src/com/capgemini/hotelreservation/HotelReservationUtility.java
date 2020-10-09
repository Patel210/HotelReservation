package com.capgemini.hotelreservation;

public class HotelReservationUtility {

	public static void main(String[] args) {
		System.out.println("Welcome to Hotel Registration");
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotelToSystem("Lakewood", 110, 90);
		hotelReservation.addHotelToSystem("Bridgewood", 150, 50);
		hotelReservation.addHotelToSystem("Ridgewood", 220, 150);
	}
}
