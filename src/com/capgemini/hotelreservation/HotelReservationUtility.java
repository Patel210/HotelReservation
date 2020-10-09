package com.capgemini.hotelreservation;

import java.text.ParseException;
import java.util.Scanner;

public class HotelReservationUtility {

	public static void main(String[] args) {
		System.out.println("Welcome to Hotel Registration");
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotelToSystem("Lakewood", 110, 90, 3, 80, 80);
		hotelReservation.addHotelToSystem("Bridgewood", 150, 50, 4, 110, 50);
		hotelReservation.addHotelToSystem("Ridgewood", 220, 150, 5, 100, 40);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the start date(ddMMMyyyy): ");
		String startDate = sc .next();
		System.out.println("Enter the end date(ddMMMyyyy): ");
		String endDate = sc .next();
		try {
			hotelReservation.viewCheapestBestRatedHotel(startDate, endDate, "Reward");
		} catch (ParseException e) {
			System.out.println("Invalid date format! Correct format: ddMMMyyyy");
		}
	}
}
