package com.hotel;

import java.util.List;
import java.util.Scanner;
/**
 * ----------------------------------------------------
 * PROCEDURE:
 * ----------------------------------------------------
 /** 
 * UC1:- Ability to add Hotel in a Hotel Reservation System with Name and
 * rates for Regular Customer...
 * UC2:- Ability to find the cheapest Hotel for a given Date Range
 * UC3:- Ability to add weekday and weekend rates for each Hotel
 * UC4:- Ability to find the cheapest Hotel for a given Date Range based on weekday
   and weekend
 * UC5:- Ability to add ratings to each Hotel - Lakewood is 3, Bridgewood is 4 and Ridgewood is 5
 */
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
		HotelDetails hotel1 = new HotelDetails("Lakewood", 3, 110, 90);
		HotelDetails hotel2 = new HotelDetails("Bridgewood", 4, 160, 60);
		HotelDetails hotel3 = new HotelDetails("Ridgewood", 5, 220, 150);

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
		System.out.println("Enter the check in date in proper format(ddMMMyyyy)");
		String startDate = sc.nextLine();
		System.out.println("Enter the check out date in proper format(ddMMMyyyy)");
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