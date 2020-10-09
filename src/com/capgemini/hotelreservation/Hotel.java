package com.capgemini.hotelreservation;

public class Hotel {
	private String hotelName;
	private int weekdayRate, weekendRate, rating, rewardCusWeekdayRate, rewardCusWeekendRate;

	public Hotel(String hotelName, int weekdayRate, int weekendRate, int rating, int rewardCusWeekdayRate,
			int rewardCusWeekendRate) {
		super();
		this.hotelName = hotelName;
		this.weekdayRate = weekdayRate;
		this.weekendRate = weekendRate;
		this.rating = rating;
		this.setRewardCusWeekdayRate(rewardCusWeekdayRate);
		this.setRewardCusWeekendRate(rewardCusWeekendRate);
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

	public int getRewardCusWeekdayRate() {
		return rewardCusWeekdayRate;
	}

	public void setRewardCusWeekdayRate(int rewardCusWeekdayRate) {
		this.rewardCusWeekdayRate = rewardCusWeekdayRate;
	}

	public int getRewardCusWeekendRate() {
		return rewardCusWeekendRate;
	}

	public void setRewardCusWeekendRate(int rewardCusWeekendRate) {
		this.rewardCusWeekendRate = rewardCusWeekendRate;
	}
}
