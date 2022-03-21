package com.hotel;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;

/**
 * In this we are creating the test cases. If the hotels are added and for that
 * adding weekday and weekend rates for each Hotel. In that we have to find the
 * cheapest hotel if cheapest hotel is present it will return true otherwise
 * throws exception
 * 
 * @author Shardul
 *
 */
public class HotelReservationTest {
	@Test
	public void WhenHotelsAreAddedFindCheapestHotel() throws ParseException {
		/**
		 * Ability to adding weekday and weekend rates for each Hotel
		 */
		HotelDetails hotel1 = new HotelDetails("Lakewood", 110, 90);
		HotelDetails hotel2 = new HotelDetails("Bridgewood", 160, 60);
		HotelDetails hotel3 = new HotelDetails("Ridgewood", 220, 150);

		/**
		 * creating instance of HotelReservation class and adding the hotels
		 */
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel(hotel1);
		hotelReservation.addHotel(hotel2);
		hotelReservation.addHotel(hotel3);

		/**
		 * finding the cheapest Hotel for a given Date Range
		 */
		HotelDetails cheapestHotel = hotelReservation.findCheapestHotel();
		long totalDays = hotelReservation.getTotalNoOfDays("10Sep2020", "11Sep2020");
		long totalCost = cheapestHotel.getWeekDayRateRegCus() * totalDays;
		assertEquals(220, totalCost);
		assertEquals("Lakewood", cheapestHotel.getHotelName());
	}

	@Test
	/**
	 * method created when hotels are added it will return size
	 */
	public void WhenHotelsAreAddedReturnSize() {
		HotelDetails hotel1 = new HotelDetails("Lakewood", 110, 90);
		HotelDetails hotel2 = new HotelDetails("Bridgewood", 160, 60);
		HotelDetails hotel3 = new HotelDetails("Ridgewood", 220, 150);

		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel(hotel1);
		hotelReservation.addHotel(hotel2);
		hotelReservation.addHotel(hotel3);
		assertEquals(3, hotelReservation.totalHotels());
	}
}