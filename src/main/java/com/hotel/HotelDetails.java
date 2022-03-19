package com.hotel;

public class HotelDetails {
	
	/**
	 * 1. created variables
	 * 2.created constructor
	 *  3. created getter and setters
	 */
	/*
	 * 1. created variables
	 */

	private String name;
	private int price;

	/*
	 * 2.created constructor
	 */

	public HotelDetails(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	/*
	 * 3. created getter and setters
	 */
	public String getName() {
		return name;
	
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "\nHotelDetails [name=" + name + ", price=" + price + "]";
	}
	
	

}
