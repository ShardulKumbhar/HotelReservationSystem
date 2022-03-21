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
 * UC6:- Ability to find the cheapest best rated hotel Hotel for a given Date Range
 * UC7:- Ability to find the Best Rated Hotel for a given Date Range
 * UC9:- Ability to add special rates for reward customers as a part of Loyalty Program
 * UC10:- Ability to find the cheapest best rated hotel Hotel for a given Date Range for a
   Reward Customer
  
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
		Customer customer = new Customer();

		/**
		 * Ability to adding weekday and weekend rates with ratings for both regular and
		 * reward customers for each Hotel
		 */
		HotelDetails hotel1 = new HotelDetails("Lakewood", 3, 110, 90, 80, 80);
		HotelDetails hotel2 = new HotelDetails("Bridgewood", 4, 150, 50, 110, 50);
		HotelDetails hotel3 = new HotelDetails("Ridgewood", 5, 220, 150, 100, 40);

		/**
		 * creating instance of HotelReservation class and adding the hotels
		 */
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel(hotel1);
		hotelReservation.addHotel(hotel2);
		hotelReservation.addHotel(hotel3);
		boolean check = false;
		/**
		 * Ability to find the cheapest best rated hotel Hotel for a given Date Range
		 * for a Reward Customer here check in date should be proper format if not then
		 * it should catch Invalid exception
		 * 
		 */
		while (!check) {
			try {
				System.out.println("Enter the check in date in proper format(ddMMMyyyy)");
				String startDate = sc.nextLine();
				check = hotelReservation.setStartDate1(startDate);
			} catch (InputValidationException e) {
				System.out.println(e.getMessage());
			}
		}
		check = false;
		while (!check) {
			/**
			 * here check out date should be proper format if not then it should catch
			 * Invalid exception
			 */
			try {
				System.out.println("Enter the check out date in proper format(ddMMMyyyy)");
				String endDate = sc.nextLine();
				check = hotelReservation.setEndDate1(endDate);
			} catch (InputValidationException e) {
				System.out.println(e.getMessage());
			}
		}
		check = false;
		while (!check) {
			/**
			 * type of customer should be proper if not catch invalid exception
			 */
			try {
				System.out.println("Enter the type of customer(Reward/Regular)");
				String typeOfCustomer = sc.nextLine();
				check = customer.setCustomerType(typeOfCustomer);
			} catch (InputValidationException e) {
				System.out.println(e.getMessage());
			}
		}
		long totalDays = hotelReservation.getTotalNoOfDays();
		String cheapestHotelBestRated = hotelReservation
				.findCheapestHotelBasedOnWeekEndAndWeekDaysOfferAndBestRatingForRewardCustomer();
		System.out.println("Hotel:Rating:Price = " + cheapestHotelBestRated);

	}
}