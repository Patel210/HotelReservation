package com.capgemini.hotelreservation;

public class Hotel {
	private String hotelName;
	private int weekdayRate, weekendRate, rating;

	public Hotel(String hotelName, int weekdayRate, int weekendRate, int rating) {
		super();
		this.hotelName = hotelName;
		this.weekdayRate = weekdayRate;
		this.weekendRate = weekendRate;
		this.rating = rating;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getWeekdayRate() {
		return weekdayRate;
	}

	public void setWeekdayRate(int weekdayRate) {
		this.weekdayRate = weekdayRate;
	}

	public int getWeekendRate() {
		return weekendRate;
	}

	public void setWeekendRate(int weekendRate) {
		this.weekendRate = weekendRate;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
