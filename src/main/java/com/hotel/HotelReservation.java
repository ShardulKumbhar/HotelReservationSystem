package com.hotel;

/**
 * ----------------------------------------------------
 * PROCEDURE:
 * ----------------------------------------------------
 /** 
 * UC1:- Ability to add Hotel in a Hotel Reservation System with Name and
 * rates for Regular Customer...
 * UC2:- Ability to find the cheapest Hotel for a given Date Range
 * UC3:- Ability to add weekday and weekend rates for each Hotel
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class HotelReservation {

	/**
	 * creating ArrayList of type Hotel to store all the Hotels getting Hotel into
	 * object and adding into the array list for testing purpose
	 */
	ArrayList<HotelDetails> listOfHotels = new ArrayList<HotelDetails>();

	/**
	 * create method addHotel to add Hotels
	 * 
	 * @param obj -passing object
	 */
	public void addHotel(HotelDetails obj) {
		listOfHotels.add(obj);
	}

	/**
	 * take the size of an array list for testing process
	 */
	public int totalHotels() {
		return listOfHotels.size();
	}

	/**
	 * create method getTotalNoOfDays to get the total days it having start date and
	 * end date if we type any other date instead of given date format it will
	 * throws parseException
	 * 
	 * @param start - start date
	 * @param end-  end date
	 * @return -return to method created
	 * @throws ParseException -throws exception
	 */
	public long getTotalNoOfDays(String start, String end) throws ParseException {
		Date startDate = new SimpleDateFormat("ddMMMyyyy").parse(start);
		Date endDate = new SimpleDateFormat("ddMMMyyyy").parse(end);
		long TotalNoOfDays = 1 + (endDate.getTime() - startDate.getTime()) / 1000 / 60 / 60 / 24;
		return TotalNoOfDays;
	}

	/**
	 * method to find Cheapest Hotel by comparing from all the hotels
	 * 
	 * @return -return to method created
	 */
	public HotelDetails findCheapestHotel() {
		HotelDetails cheapestHotel = listOfHotels.stream().min(Comparator.comparing(HotelDetails::getWeekDayRateRegCus)).orElse(null);
		return cheapestHotel;
	}

	/**
	 * Main method for manipulation of Arraylist of Hotel
	 * 
	 * @param args - Default Java param (Not used)
	 */
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Hotel Reservation System!");
		HotelDetails hotel1 = new HotelDetails("Lakewood", 110, 90);
		HotelDetails hotel2 = new HotelDetails("Bridgewood", 160, 60);
		HotelDetails hotel3 = new HotelDetails("Ridgewood", 220, 150);
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel(hotel1);
		hotelReservation.addHotel(hotel2);
		hotelReservation.addHotel(hotel3);
		System.out.println("Enter the check in date in proper format(ddMMMyyyy) ex:10Sep2020 ");
		String startDate = sc.nextLine();
		System.out.println("Enter the check out date in proper format(ddMMMyyyy) ex:11Sep2020 ");
		String endDate = sc.nextLine();

		/**
		 * finding the cheapest Hotel for a given Date Range
		 */
		HotelDetails cheapestHotel = hotelReservation.findCheapestHotel();
		long totalDays = hotelReservation.getTotalNoOfDays("10Sep2020", "11Sep2020");
		long totalCost = cheapestHotel.getWeekDayRateRegCus() * totalDays;

		System.out.println("Cheapest Hotel for your stay: " + cheapestHotel.getHotelName());
		System.out.println("Total expense: " + totalCost);

	}
}