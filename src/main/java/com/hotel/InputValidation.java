package com.hotel;

	/**
	 * If we want to represent a group of strings according to a particular pattern then we should go for regular
	 * expressions
	 */
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;

	public class InputValidation {

		/**
		 * create method dateValidation by passing string date
		 * 
		 * @param date -passing date
		 * @return -return to method created
		 */
		public boolean dateValidation(String date) {
			Pattern pattern = Pattern.compile("^([0-3]){1}([0-9]){1}([a-z]){3}([1-9]){1}([0-9]){3}$");
			Matcher matcher = pattern.matcher(date);
			boolean isValid = matcher.find();
			return isValid;
		}

		/**
		 * created method for validation of customers
		 * 
		 * @param customerType -passing customer type
		 * @return -return to method created
		 */
		public boolean CustomerValidation(String customerType) {
			Pattern pattern = Pattern.compile("[A-Z]{1}[a-z]+");
			Matcher matcher = pattern.matcher(customerType);
			boolean isValid = matcher.find();
			return isValid;
		}
	}

