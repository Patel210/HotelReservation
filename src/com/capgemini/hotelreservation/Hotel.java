package com.capgemini.hotelreservation;

public class Hotel {
	private String hotelName;
	private int regularRate;

	public Hotel(String hotelName, int regularRate) {
		super();
		this.hotelName = hotelName;
		this.regularRate = regularRate;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getRegularRate() {
		return regularRate;
	}

	public void setRegularRate(int regularRate) {
		this.regularRate = regularRate;
	}

}
