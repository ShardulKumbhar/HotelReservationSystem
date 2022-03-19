package com.hotel;

import java.util.ArrayList;



public class HotelReservation {
	
	/**
	 * PROCEDURE
	 * ==================================================
	 * 1.created one Arraylist to store hotels
	 * 2. method to add hotels to new 
	 * 3. method to check number of hotels in list
	 * ===================================================
	 */
	
	/*
	 * 1.created one Arraylist to store hotels
	 */
	 ArrayList<HotelDetails> hotelList = new ArrayList<HotelDetails>();
	

	/*
	 *2. method to add hotels to new 
	 */
	public void addNewHotel(String name, int price) {
		HotelDetails temp=new HotelDetails(name,price);
		hotelList.add(temp);
		System.out.println(temp);
	}
	
	
	/*
	 *3. method to check number of hotels in list
	 */
	public int countNoOfHotels() {
		return hotelList.size();
		
	}
	
}
