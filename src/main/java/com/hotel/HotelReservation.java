package com.hotel;
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
	private String startDate1, endDate1;

	/**
	 * getting the startDate1 having return type
	 * 
	 * @return
	 */
	public String getStartDate1() {
		return startDate1;
	}

	/**
	 * boolean method to setStartDate1 in proper way if not throws exception
	 * 
	 * @param startDate1
	 * @return
	 * @throws InputValidationException
	 */
	public boolean setStartDate1(String startDate1) throws InputValidationException {
		boolean check = false;
		InputValidation inputValidation = new InputValidation();
		check = inputValidation.dateValidation(startDate1);
		if (check)
			this.startDate1 = startDate1;
		else
			throw new InputValidationException("Enter proper checkin date");
		return check;
	}

	public String getEndDate1() {
		return endDate1;
	}

	public boolean setEndDate1(String endDate1) throws InputValidationException {
		boolean check = false;
		InputValidation inputValidation = new InputValidation();
		check = inputValidation.dateValidation(endDate1);
		if (check)
			this.endDate1 = endDate1;
		else
			throw new InputValidationException("Enter proper checkout date");
		return check;
	}

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
	public long getTotalNoOfDays() throws ParseException {
		startDate = new SimpleDateFormat("ddMMMyyyy").parse(getStartDate1());
		endDate = new SimpleDateFormat("ddMMMyyyy").parse(getEndDate1());
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
	public List<String> findCheapestHotelBasedOnWeekEndAndWeekDaysOffer() throws ParseException {
		long totalDays = getTotalNoOfDays();
		long totalWeekendDays = getTotalWeekendDays();
		long totalWeekDays = totalDays - totalWeekendDays;

		/**
		 * creating Stream from list of hotelRentList. Filter operation produces a new
		 * stream that contains elements of the original stream that pass a given
		 * test(specified by a Predicate). filter(),is a Intermediate operations return
		 * a new stream on which further processing can be done. here filter is used to
		 * search particular hotel and the filtered stream is creates a list and will
		 * collect
		 **/
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
	 * Ability to find the cheapest Hotel for a given Date Range based on weekday
	 * and weekend
	 * 
	 * @param startDate1 -passing start Date1
	 * @param endDate1   -passing endDate1
	 * @return return to method created
	 * @throws ParseException -throws exception
	 */
	public String findCheapestHotelBasedOnWeekEndAndWeekDaysOfferAndBestRating() throws ParseException {
		long totalDays = getTotalNoOfDays();
		long totalWeekendDays = getTotalWeekendDays();
		long totalWeekDays = totalDays - totalWeekendDays;
		List<Long> costOfHotelList = listOfHotels.stream().map(hotel -> {
			return (hotel.getWeekDayRateRegCus() * totalWeekDays + hotel.getWeekEndRateRegCus() * totalWeekendDays);
		}).collect(Collectors.toList());
		long minCost = Collections.min(costOfHotelList);
		List<HotelDetails> cheapHotelList = listOfHotels.stream().filter(hotel -> hotel.getWeekDayRateRegCus() * totalWeekDays
				+ hotel.getWeekEndRateRegCus() * totalWeekendDays == minCost).collect(Collectors.toList());
		HotelDetails bestRatingHotel = cheapHotelList.stream().max(Comparator.comparing(HotelDetails::getRating)).orElse(null);

		/**
		 * ForEach() method is used and it is a Terminal operations mark the stream as
		 * consumed, after which point it can no longer be used further.
		 */
		for (HotelDetails name : cheapHotelList) {
			if (name.getRating() == bestRatingHotel.getRating()) {
				return name.getHotelName() + ":" + name.getRating() + ":" + minCost;
			}
		}
		return null;
	}

	/**
	 * Ability to find the Best Rated Hotel for a given Date Range
	 * 
	 * @param startDate1-passing start date1
	 * @param endDate1           - end date1
	 * @return return to method created
	 * @throws ParseException - throws exception
	 */
	public String findBestRatedHotel() throws ParseException {
		HotelDetails bestRatedHotel = listOfHotels.stream().max(Comparator.comparing(HotelDetails::getRating)).orElse(null);
		long totalDays = getTotalNoOfDays();
		long totalWeekendDays = getTotalWeekendDays();
		long totalWeekDays = totalDays - totalWeekendDays;
		long costOfHotel = CostOfHotel(bestRatedHotel, totalWeekendDays, totalWeekDays);
		return bestRatedHotel.getHotelName() + ":" + costOfHotel;
	}

	/**
	 * finding the cost of each hotel based on weekdays and weekend
	 * 
	 * @param hotel
	 * @param weekDays
	 * @param weekendDays
	 * @return
	 */
	public long CostOfHotel(HotelDetails hotel, long weekDays, long weekendDays) {
		return (hotel.getWeekDayRateRegCus() * weekDays + hotel.getWeekEndRateRegCus() * weekendDays);
	}

	/**
	 * Ability to find the cheapest best rated hotel Hotel for a given Date Range
	 * for a Reward Customer
	 * 
	 * @return
	 * @throws ParseException
	 */
	public String findCheapestHotelBasedOnWeekEndAndWeekDaysOfferAndBestRatingForRewardCustomer()
			throws ParseException {
		long totalDays = getTotalNoOfDays();
		long totalWeekendDays = getTotalWeekendDays();
		long totalWeekDays = totalDays - totalWeekendDays;

		/**
		 * creating Stream from list of costOfHotelList. Filter operation produces a new
		 * stream that contains elements of the original stream that pass a given
		 * test(specified by a Predicate). filter(),is a Intermediate operations return
		 * a new stream on which further processing can be done. here filter is used to
		 * search particular hotel and the filtered stream is creates a list and will
		 * collect in a costOfHotelList using collector
		 */
		List<Long> costOfHotelList = listOfHotels.stream().map(hotel -> {
			return (hotel.getWeekDayRateRewardCus() * totalWeekDays
					+ hotel.getWeekEndRateRewardCus() * totalWeekendDays);
		}).collect(Collectors.toList());
		long minCost = Collections.min(costOfHotelList);
		List<HotelDetails> cheapHotelList = listOfHotels.stream()
				.filter(hotel -> hotel.getWeekDayRateRewardCus() * totalWeekDays
						+ hotel.getWeekEndRateRewardCus() * totalWeekendDays == minCost)
				.collect(Collectors.toList());
		HotelDetails bestRatingHotel = cheapHotelList.stream().max(Comparator.comparing(HotelDetails::getRating)).orElse(null);
		for (HotelDetails name : cheapHotelList) {
			if (name.getRating() == bestRatingHotel.getRating()) {
				return name.getHotelName() + ":" + name.getRating() + ":" + minCost;
			}
		}
		return null;
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