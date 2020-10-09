package com.capgemini.hotelreservation;

public class Hotel {
	private String hotelName;
	private int weekdayRate, weekendRate;

	public Hotel(String hotelName, int weekdayRate, int weekendRate) {
		super();
		this.hotelName = hotelName;
		this.weekdayRate = weekdayRate;
		this.weekendRate = weekendRate;
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
}
