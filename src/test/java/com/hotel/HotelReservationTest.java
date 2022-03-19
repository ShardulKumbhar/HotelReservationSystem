package com.hotel;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest {
	
	/*
	 * STEPS
	 * ==============================================
	 * 1.created object of class hotel reservation
	 * 2.adding hotels
	 * 3.checking no of hotels
	 * ==============================================
	 */

	@Test
	public void test() {
		/*
		 * 1.created object of class hotel reservation
		 */
		HotelReservation hotels =new HotelReservation();
		/*
		 * 2.adding hotels
		 */
		hotels.addNewHotel("Lakewood",110);
		hotels.addNewHotel("Bridgewood",160);
		hotels.addNewHotel("Ridgewood",220);
	/*
	 * 3.checking no of hotels
	 */
		Assert.assertEquals(3, hotels.countNoOfHotels());
	}

}
