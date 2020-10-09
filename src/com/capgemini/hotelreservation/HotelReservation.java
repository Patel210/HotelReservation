package com.capgemini.hotelreservation;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HotelReservation {

	private Map<String, Hotel> availableHotels = new HashMap<String, Hotel>();

	public HotelReservation() {
		super();
	}

	/**
	 * @param hotelName
	 * @param weekdayRate
	 * @param weekendRate Add Hotel in the system
	 */
	public void addHotelToSystem(String hotelName, int weekdayRate, int weekendrate, int rating,
			int rewardCusWeekdayRate, int rewardCusWeekendRate) {
		Hotel hotel = new Hotel(hotelName, weekdayRate, weekendrate, rating, rewardCusWeekdayRate,
				rewardCusWeekendRate);
		availableHotels.put(hotelName, hotel);
		System.out.println("Hotel added  successfully!");
	}

	/**
	 * @param startDate
	 * @param endDate
	 * @return array containing no. of week days and no. of weekend days in format
	 *         array[0]=weekdays and array[1] = weekend days
	 * @throws ParseException
	 */
	private int[] getWeekDaysAndWeekendDays(String startDate, String endDate) throws ParseException {
		LocalDate endDateOfReservation = null, startDateOfReservation = null;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMMyyyy");
		startDateOfReservation = LocalDate.parse(startDate, dtf);
		endDateOfReservation = LocalDate.parse(endDate, dtf);

		LocalDate tempDate = startDateOfReservation;
		int noOfDays = (int) ChronoUnit.DAYS.between(startDateOfReservation, endDateOfReservation) + 1;
		int noOfWeekendDays = 0;
		for (int i = 0; i < noOfDays; i++) {
			DayOfWeek day = DayOfWeek.of(tempDate.get(ChronoField.DAY_OF_WEEK));
			switch (day) {
			case SATURDAY:
				noOfWeekendDays++;
				break;
			case SUNDAY:
				noOfWeekendDays++;
				break;
			}
			tempDate = tempDate.plusDays(1);
		}
		return new int[] { noOfDays - noOfWeekendDays, noOfWeekendDays };
	}

	/**
	 * @param startDate
	 * @param endDate
	 * @throws ParseException View the cheapest best rated hotel if present
	 */
	public void viewCheapestBestRatedHotel(String startDate, String endDate, String customerType)
			throws ParseException {
		int[] countOfDiffDays = getWeekDaysAndWeekendDays(startDate, endDate);
		if (availableHotels.size() != 0) {
			Function<Hotel, Integer> toGetRates;
			if (customerType.equalsIgnoreCase("Regular")) {
				toGetRates = hotel -> Integer.sum(hotel.getWeekdayRate() * countOfDiffDays[0],
						hotel.getWeekendRate() * countOfDiffDays[1]);
			} else {
				toGetRates = hotel -> Integer.sum(hotel.getRewardCusWeekdayRate() * countOfDiffDays[0],
						hotel.getRewardCusWeekendRate() * countOfDiffDays[1]);
			}
			int cheapestRate = availableHotels.entrySet().stream().map(entry -> toGetRates.apply(entry.getValue()))
					.min((i, j) -> i.compareTo(j)).orElse(0);

			Map<String, Hotel> cheapestHotels = availableHotels.entrySet().stream()
					.filter(entry -> toGetRates.apply(entry.getValue()) == cheapestRate)
					.collect(Collectors.toMap(stream -> stream.getKey(), stream -> stream.getValue()));

			Function<Hotel, Integer> toGetRating = hotel -> hotel.getRating();
			int maxRating = cheapestHotels.entrySet().stream().map(entry -> toGetRating.apply(entry.getValue()))
					.max((i, j) -> i.compareTo(j)).get();

			cheapestHotels.entrySet().stream().filter(entry -> toGetRating.apply(entry.getValue()) == maxRating)
					.forEach(entry -> System.out
							.println("Cheapest Hotel With Best Rating for " + customerType + " customer: "
									+ entry.getKey() + ", Rating: " + maxRating + ", Total rates: $" + cheapestRate));
		} else {
			System.out.println("Sorry! No Hotel is available in the system");
		}
	}

	/**
	 * @param startDate
	 * @param endDate
	 * @throws ParseException View the best rated hotel if present
	 */
	public void viewBestRatedHotel(String startDate, String endDate, String customerType) throws ParseException {
		int[] countOfDiffDays = getWeekDaysAndWeekendDays(startDate, endDate);
		if (availableHotels.size() != 0) {
			Function<Hotel, Integer> toGetRates;
			if (customerType.equalsIgnoreCase("Regular")) {
				toGetRates = hotel -> Integer.sum(hotel.getWeekdayRate() * countOfDiffDays[0],
						hotel.getWeekendRate() * countOfDiffDays[1]);
			} else {
				toGetRates = hotel -> Integer.sum(hotel.getRewardCusWeekdayRate() * countOfDiffDays[0],
						hotel.getRewardCusWeekendRate() * countOfDiffDays[1]);

			}
			Function<Hotel, Integer> toGetRating = hotel -> hotel.getRating();
			int maxRating = availableHotels.entrySet().stream().map(entry -> toGetRating.apply(entry.getValue()))
					.max((i, j) -> i.compareTo(j)).get();
			availableHotels.entrySet().stream().filter(entry -> toGetRating.apply(entry.getValue()) == maxRating)
					.forEach(entry -> System.out
							.println("Best Hotel for " + customerType + " customer: " + entry.getKey() + ", Rating: "
									+ maxRating + " Total rates: $" + toGetRates.apply(entry.getValue())));
		} else {
			System.out.println("Sorry! No Hotel is available in the system");
		}
	}
}
