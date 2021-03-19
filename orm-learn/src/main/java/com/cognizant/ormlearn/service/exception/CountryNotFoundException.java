package com.cognizant.ormlearn.service.exception;

/*Create new exception class CountryNotFoundException in com.cognizant.spring-learn.service.exception
*/
public class CountryNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

		public CountryNotFoundException(String msg) {
			super(msg);
		}
}
