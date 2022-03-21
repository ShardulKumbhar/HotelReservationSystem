package com.hotel;

public class HotelDetails {

	/**
	 * private variables can only be accessed within the same class (an outside
	 * class has no access to it) private = restricted access However, it is
	 * possible to access them if we provide public get and set methods.
	 */
	private String hotelName;
	private int rating;
	private int weekDayRateRegCus;
	private int weekEndRateRegCus;
	private int weekDayRateRewardCus;
	private int weekEndRateRewardCus;

	/**
	 * creating a parameterized constructor of Hotel by passing parameters with no
	 * return type
	 * 
	 * @param hotelName                    -passing hotelNames
	 * @param rating                       -passing rating of hotels
	 * @param weekDayRateRegCus-passing    weekday rate of regular customers
	 * @param weekEndRateRegCus-passing    weekend rate of regular customers
	 * @param weekDayRateRewardCus-passing weekday rate of reward customers
	 * @param weekEndRateRewardCus-passing weekend rate of reward customers
	 */
	public HotelDetails(String hotelName, int rating, int weekDayRateRegCus, int weekEndRateRegCus, int weekDayRateRewardCus,
			int weekEndRateRewardCus) {
		super();
		this.hotelName = hotelName;
		this.rating = rating;
		this.weekDayRateRegCus = weekDayRateRegCus;
		this.weekEndRateRegCus = weekEndRateRegCus;
		this.weekDayRateRewardCus = weekDayRateRewardCus;
		this.weekEndRateRewardCus = weekEndRateRewardCus;
	}
	/**
	 * Setter getters
	 * 
	 */

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getWeekDayRateRegCus() {
		return weekDayRateRegCus;
	}

	public void setWeekDayRateRegCus(int weekDayRateRegCus) {
		this.weekDayRateRegCus = weekDayRateRegCus;
	}

	public int getWeekEndRateRegCus() {
		return weekEndRateRegCus;
	}

	public void setWeekEndRateRegCus(int weekEndRateRegCus) {
		this.weekEndRateRegCus = weekEndRateRegCus;
	}

	public int getWeekDayRateRewardCus() {
		return weekDayRateRewardCus;
	}

	public void setWeekDayRateRewardCus(int weekDayRateRewardCus) {
		this.weekDayRateRewardCus = weekDayRateRewardCus;
	}

	public int getWeekEndRateRewardCus() {
		return weekEndRateRewardCus;
	}

	public void setWeekEndRateRewardCus(int weekEndRateRewardCus) {
		this.weekEndRateRewardCus = weekEndRateRewardCus;
	}

}