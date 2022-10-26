package cn.prinf.demos.junit.basic;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static cn.prinf.demos.junit.basic.ExceptionPractise.divide;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ExceptionPractiseTest {

    @Test
    public void should_divide_number() {
        assertEquals(3, divide(9, 3));
    }

    @Test(expected = DivideByZeroException.class)
    public void should_get_error_when_divisor_is_zero() {
        assertEquals(3, divide(9, 0));
    }

    @Test
    public void test_exception_by_try_catch() {
        try {
            divide(9, 0);
            fail("Expected DivideByZeroException be thrown");
        } catch (DivideByZeroException divideByZeroException) {
            assertThat(divideByZeroException.getMessage(), is("divisor is zero"));
        }
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test_exception_by_rule() throws IndexOutOfBoundsException {
        thrown.expect(DivideByZeroException.class);
        thrown.expectMessage("divisor is zero");
        divide(9, 0);
    }

    @Test
    public void should_assert_exception_type_and_message() {
        DivideByZeroException divideByZeroException = assertThrows(DivideByZeroException.class, () -> divide(9, 0));
        assertEquals("divisor is zero", divideByZeroException.getMessage());
    }
}
