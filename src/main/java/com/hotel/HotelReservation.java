package com.hotel;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class HotelReservation {

	/**
	 * creating ArrayList of type Hotel to store all the Hotels getting Hotel into
	 * object and adding into the array list for testing purpose
	 */
	ArrayList<HotelDetails> listOfHotels = new ArrayList<HotelDetails>();
	Date startDate;
	Date endDate;

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
	public long getTotalNoOfDays(String startDate1, String endDate1) throws ParseException {
		startDate = new SimpleDateFormat("ddMMMyyyy").parse(startDate1);
		endDate = new SimpleDateFormat("ddMMMyyyy").parse(endDate1);
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
	 * Creating a List of type String
	 * 
	 * @param startDate1 -passing startDate1
	 * @param endDate1   -passing endDate1
	 * @return -return to method created
	 * @throws ParseException -throws exception
	 */
	public List<String> findCheapestHotelBasedOnWeekEndAndWeekDaysOffer(String startDate1, String endDate1)
			throws ParseException {
		long totalDays = getTotalNoOfDays(startDate1, endDate1);
		long totalWeekendDays = getTotalWeekendDays();
		long totalWeekDays = totalDays - totalWeekendDays;

		/**
		 * creating Stream from list of hotelRentList. Filter operation produces a new
		 * stream that contains elements of the original stream that pass a given
		 * test(specified by a Predicate). filter(),is a Intermediate operations return
		 * a new stream on which further processing can be done. here filter is used to
		 * search particular hotel and the filtered stream is creates a list and will
		 * collect in a hotelRentList using collector
		 */
		List<Long> hotelRentList = listOfHotels.stream().map(hotel -> {
			return (hotel.getWeekDayRateRegCus() * totalWeekDays + hotel.getWeekEndRateRegCus() * totalWeekendDays);
		}).collect(Collectors.toList());
		long minRent = Collections.min(hotelRentList);
		List<String> cheapHotelList = listOfHotels.stream()
				.filter(hotel -> hotel.getWeekDayRateRegCus() * totalWeekDays
						+ hotel.getWeekEndRateRegCus() * totalWeekendDays == minRent)
				.map(hotel -> hotel.getHotelName()).collect(Collectors.toList());

		return cheapHotelList;
	}

	/**
	 * create method getTotalWeekendDays() to get totalweekenddays otherwise throws
	 * exception
	 * 
	 * @return -return to method created
	 * @throws ParseException -throws exception
	 */
	public long getTotalWeekendDays() throws ParseException {
		long totalWeekendDays = 0;
		Calendar startCalendar = Calendar.getInstance();
		startCalendar.setTime(startDate);
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(endDate);

		/**
		 * ForEach() method is used and it is a Terminal operations mark the stream as
		 * consumed, after which point it can no longer be used further.
		 */
		for (; startCalendar.compareTo(endCalendar) <= 0; startCalendar.add(Calendar.DATE, 1)) {
			int dayOfWeek = startCalendar.get(Calendar.DAY_OF_WEEK);
			if (dayOfWeek == 0 || dayOfWeek == 6)
				totalWeekendDays++;
		}
		return totalWeekendDays;
	}

}