
package com.app.exception;

import java.util.List;

/**
 * Exception created to be thrown when the application is used with negative
 * numbers.
 * <p/>
 * This exception contains information about the negative numbers that throws
 * the exception.
 */
public class NegativeNumbersNotSupportedException extends ValidatorException {

	private static final String EXCEPTION_NAME = "NegativeNumbersNotSupportedException";

	private List<Integer> negativeNumbers;

	public NegativeNumbersNotSupportedException(List<Integer> negativeNumbers) {
		this.negativeNumbers = negativeNumbers;
	}

	public static String getExceptionName() {
		return EXCEPTION_NAME;
	}

	
	public String getMessage() {
		return EXCEPTION_NAME + negativeNumbers.toString();
	}
}
