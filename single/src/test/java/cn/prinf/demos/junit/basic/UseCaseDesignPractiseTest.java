package cn.prinf.demos.junit.basic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UseCaseDesignPractiseTest {

    @Test
    public void should_be_true_if_value_is_eight() {
        // given
        int inputValue = 8;
        // when
        boolean palindrome = isPalindrome(inputValue);
        // then
        assertTrue(palindrome);
    }

    @Test
    public void should_be_false_if_value_is_MIN() {
        // given
        int inputValue = Integer.MIN_VALUE;
        // when
        boolean palindrome = isPalindrome(inputValue);
        // then
        assertFalse(palindrome);
    }

    @Test
    public void should_be_true_if_value_is_zero() {
        // given
        int inputValue = 0;
        // when
        boolean palindrome = isPalindrome(inputValue);
        // then
        assertTrue(palindrome);
    }

    @Test
    public void should_be_true_if_value_is_10() {
        // given
        int inputValue = 10;
        // when
        boolean palindrome = isPalindrome(inputValue);
        // then
        assertFalse(palindrome);
    }

    @Test
    public void should_be_true_if_value_is_11() {
        // given
        int inputValue = 11;
        // when
        boolean palindrome = isPalindrome(inputValue);
        // then
        assertTrue(palindrome);
    }

    @Test
    public void should_be_false_if_value_is_MAX() {
        // given
        int inputValue = Integer.MAX_VALUE;
        // when
        boolean palindrome = isPalindrome(inputValue);
        // then
        assertFalse(palindrome);
    }

    @Test
    public void should_return_fizz_buzz() {
        // given
        int inputValue = 15;
        // when
        String result = simpleFizzBuzz(inputValue);
        // then
        assertEquals("fizz buzz", result);
    }

    @Test
    public void should_return_fizz() {
        // given
        int inputValue = 3;
        // when
        String result = simpleFizzBuzz(inputValue);
        // then
        assertEquals("fizz", result);
    }

    @Test
    public void should_return_buzz() {
        // given
        int inputValue = 5;
        // when
        String result = simpleFizzBuzz(inputValue);
        // then
        assertEquals("buzz", result);
    }

    @Test
    public void should_return_null() {
        // given
        int inputValue = 7;
        // when
        String result = simpleFizzBuzz(inputValue);
        // then
        assertEquals(null, result);
    }

    public static String simpleFizzBuzz(int n) {
        if (n % 3 == 0 && n % 5 == 0) {
            return "fizz buzz";
        } else if (n % 3 == 0) {
            return "fizz";
        } else if (n % 5 == 0) {
            return "buzz";
        }
        return null;
    }


    public static boolean isPalindrome(int inputValue) {
        if (inputValue < 0) {
            return false;
        }
        int reverseValue = 0;
        int intermediateValue = inputValue;
        while (intermediateValue != 0) {
            reverseValue = reverseValue * 10 + intermediateValue % 10;
            intermediateValue /= 10;
        }
        return reverseValue == inputValue;
    }
}
