package com.hotel;

public class HotelDetails {
	/**
	 * private variables can only be accessed within the same class (an outside
	 * class has no access to it) private = restricted access However, it is
	 * possible to access them if we provide public get and set methods.
	 */
	private String hotelName;
	private int weekEndRateRegCus;
	private int weekDayRateRegCus;

	/**
	 * creating a parameterized constructor of Hotel by passing parameters with no
	 * 
	 */
	public HotelDetails(String hotelName, int weekDayRateRegCus) {
		super();
		this.hotelName = hotelName;
		this.weekDayRateRegCus = weekDayRateRegCus;
	}

	/**
	 * getter setter
	 * @return
	 */
	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getWeekEndRateRegCus() {
		return weekEndRateRegCus;
	}

	public void setWeekEndRateRegCus(int weekEndRateRegCus) {
		this.weekEndRateRegCus = weekEndRateRegCus;
	}

	public int getWeekDayRateRegCus() {
		return weekDayRateRegCus;
	}

	public void setWeekDayRateRegCus(int weekDayRateRegCus) {
		this.weekDayRateRegCus = weekDayRateRegCus;
	}

}