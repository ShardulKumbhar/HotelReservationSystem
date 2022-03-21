package com.hotel;

public class Customer {
	private String customerType;

	/**
	 * created Default constructor of Customer class
	 */
	public Customer() {

	}

	/**
	 * method for getting the customerType with no attributes
	 * 
	 * @return
	 */
	public String getCustomerType() {
		return customerType;
	}

	/**
	 * created method for setCustomerType
	 * 
	 * @param customerType -passing customer type
	 * @return -return to method created
	 * @throws InputValidationException -throws exception
	 */
	public boolean setCustomerType(String customerType) throws InputValidationException {
		boolean check = false;
		InputValidation inputValidation = new InputValidation();
		check = inputValidation.CustomerValidation(customerType);

		/**
		 * checking the customer type is valid or not if not then it will throws invalid
		 * exception
		 */
		if (check)
			this.customerType = customerType;
		else
			throw new InputValidationException("Enter proper customer type");

		return check;
	}

}