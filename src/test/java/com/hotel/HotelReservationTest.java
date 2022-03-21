package com.hotel;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;
public class HotelReservationTest {
	@Test
	public void WhenHotelsAreAddedReturnSize() throws ParseException {
		HotelDetails hotel1 = new HotelDetails("Lakewood", 110);
		HotelDetails hotel2 = new HotelDetails("Bridgewood", 160);
		HotelDetails hotel3 = new HotelDetails("Ridgewood", 220);

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
}