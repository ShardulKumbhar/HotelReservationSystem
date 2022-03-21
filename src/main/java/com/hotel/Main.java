package com.hotel;

import java.util.List;
import java.util.Scanner;

public class Main {

	/**
	 * Main method for manipulation of Arraylist of Hotel
	 * 
	 * @param args - Default Java param (Not used)
	 */
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Hotel Reservation System!");

		/**
		 * Ability to adding weekday and weekend rates for each Hotel
		 */
		HotelDetalis hotel1 = new HotelDetalis("Lakewood", 110, 90);
		HotelDetalis hotel2 = new HotelDetalis("Bridgewood", 160, 60);
		HotelDetalis hotel3 = new HotelDetalis("Ridgewood", 220, 150);

		/**
		 * creating instance of HotelReservation class and adding the hotels
		 */
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel(hotel1);
		hotelReservation.addHotel(hotel2);
		hotelReservation.addHotel(hotel3);

		/**
		 * Ability to find the cheapest Hotel for a given Date Range based on weekday
		 * and weekend - I/P – 11Sep2020, 12Sep2020
		 */
		System.out.println("Enter the check in date in proper format(ddMMMyyyy) ex:21Sep2000");
		String startDate = sc.nextLine();
		System.out.println("Enter the check out date in proper format(ddMMMyyyy) ex: 21Sep2000");
		String endDate = sc.nextLine();
		long totalDays = hotelReservation.getTotalNoOfDays(startDate, endDate);

		/**
		 * creating list of cheapHotelList here finding of cheapest hotel based on
		 * weekday and weekend rates
		 */
		List<String> cheapHotelList = hotelReservation.findCheapestHotelBasedOnWeekEndAndWeekDaysOffer(startDate,
				endDate);

		/**
		 * ForEach() method is used and it is a Terminal operations mark the stream as
		 * consumed, after which point it can no longer be used further.
		 */
		for (String name : cheapHotelList) {
			System.out.println("Cheapest Hotel for your stay: " + name);
		}

	}
}