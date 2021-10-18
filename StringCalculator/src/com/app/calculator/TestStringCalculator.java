package com.app.calculator;

import com.app.exception.NegativeNumbersNotSupportedException;
import com.app.exception.ValidatorException;

import org.junit.Before;
import org.junit.Test;

public class TestStringCalculator {


	

	/**
	 * Test created to check the correct behaviour of the StringCalculator application.
	 * <p/>
	 * The string calculator class should get a string with some numbers inside and calculate the sum of different values.
	 * <p/>
	 * This test suit contains some integration tests that describes the application behaviour.
	 *
	 */
	public class StringCalculatorTest {

	    private static final String EMPTY_SET_OF_NUMBERS = "";
	    private static final String ONE_NUMBER_ONE_DIGIT_STRING = "1";
	    private static final String ONE_NUMBER_STRING = "11";
	    private static final String NUMBERS_STRING_SUM_ELEVEN = "1,2,3,5";
	    private static final String NUMBERS_STRING_SUM_SIX_SEPARATOR_NEW_LINE = "1\n2,3";
	    private static final String NUMBERS_STRING_SUM_SEVEN_DIFFERENT_SEPARATORS = "//;\n1;2p4";
	    private static final String NUMBERS_STRING_WITH_NEGATIVE_VALUES = "//;\n1;2p-4";
	    private static final String NUMBERS_STRING_SUM_TWO_WITH_MORE_THAN_THOUSAND = "2,1000";
	    private static final String NUMBERS_STRING_SUM_SEVEN_DIFFERENT_SEPARATORS_CONSECUTIVES = "[*][%]\\n1*2%4";

	    private StringCalculator stringCalculator;

	    @Before
	    public void setUp() {
	        stringCalculator = new StringCalculator();
	    }

	    @Test
	    public void shouldReturnZeroIfTheArgumentIsEmpty() throws ValidatorException {
	        int result = stringCalculator.add(EMPTY_SET_OF_NUMBERS);

	        assertEquals(0, result);
	    }

	    @Test
	    public void shouldReturnTheSameValueIfTheArgumentContainsOnlyOneNumberWithOneDigit() throws ValidatorException {
	        int result = stringCalculator.add(ONE_NUMBER_ONE_DIGIT_STRING);

	        int expectedResult = Integer.parseInt(ONE_NUMBER_ONE_DIGIT_STRING);
	        assertEquals(expectedResult, result);
	    }

	    @Test
	    public void shouldReturnTheSameValueIfTheArgumentContainisOnlyOneNumberWithMoreThanOneDigit() throws ValidatorException {
	        int result = stringCalculator.add(ONE_NUMBER_STRING);

	        int expectedResult = Integer.parseInt(ONE_NUMBER_STRING);
	        assertEquals(expectedResult, result);
	    }

	    @Test
	    public void shouldReturnTheSumOfAnUnknownAmountOfNumbers() throws ValidatorException {
	        int result = stringCalculator.add(NUMBERS_STRING_SUM_ELEVEN);

	        assertEquals(11, result);
	    }

	    @Test
	    public void shouldReturnTheSumOfAnUnknownAmountOfNumbersSeparatedWithNewLineCharacters() throws ValidatorException {
	        int result = stringCalculator.add(NUMBERS_STRING_SUM_SIX_SEPARATOR_NEW_LINE);

	        assertEquals(6, result);
	    }

	    @Test
	    public void shouldReturnTheSumOfAnUnknownAmoutOfNumbersSeparatedWithDifferentDelimiters() throws ValidatorException {
	        int result = stringCalculator.add(NUMBERS_STRING_SUM_SEVEN_DIFFERENT_SEPARATORS);

	        assertEquals(7, result);
	    }

	    @Test(expected = NegativeNumbersNotSupportedException.class)
	    public void shouldThrowNegativeNumbersNotSupportedException() throws ValidatorException {
	        stringCalculator.add(NUMBERS_STRING_WITH_NEGATIVE_VALUES);
	    }

	    @Test
	    public void shouldIgnoreNumbersGratherThanOneThousand() throws ValidatorException {
	        int result = stringCalculator.add(NUMBERS_STRING_SUM_TWO_WITH_MORE_THAN_THOUSAND);

	        assertEquals(2, result);
	    }

	    @Test
	    public void shouldAllowDifferentDelimitersWithMoreThanOneCharAndMoreThanOneConsecutive() throws ValidatorException {
	        int result = stringCalculator.add(NUMBERS_STRING_SUM_SEVEN_DIFFERENT_SEPARATORS_CONSECUTIVES);

	        assertEquals(7, result);
	    }

	}

	public void assertEquals(int i, int result) {
		// TODO Auto-generated method stub
		
	}