package com.hotel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;



public class HotelReservation {
	
	/**
	 * PROCEDURE ================================================== 1.created one
	 * Arraylist to store hotels 2. method to add hotels to new 3. method to check
	 * number of hotels in list ===================================================
	 */

	/*
	 * 1.created one Arraylist to store hotels
	 */
	static ArrayList<HotelDetails> hotelList = new ArrayList<HotelDetails>();

	/*
	 * 2. method to add hotels to new
	 */
	public void addNewHotel(String name, int price) {
		HotelDetails temp = new HotelDetails(name, price);
		hotelList.add(temp);
	}

	/*
	 * 3. method to check number of hotels in list
	 */
	public int countNoOfHotels() {
		return hotelList.size();

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("***********Welcome to Hotel Reservation************");
		
		System.out.println("How many Hotels you want to enter");
		int num=sc.nextInt();

		for (int i = 1; i <= num; i++) {
			System.out.println("Enter the hotel name : ");
			String hotelName = sc.next();
			System.out.println("Enter the Rates : ");
			int rates = sc.nextInt();

			/*
			 * Passing user input details into object of a constructor and adding that
			 * object to the arraylist
			 */
			HotelDetails list = new HotelDetails(hotelName, rates);
			hotelList.add(list);
		}
		System.out.println(hotelList);
	}
}
