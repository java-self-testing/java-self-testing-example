package cn.prinf.demos.junit.basic;

import org.junit.Test;

import java.util.Arrays;

import static cn.prinf.demos.junit.basic.AssertPractise.calculateAA;
import static cn.prinf.demos.junit.basic.AssertPractise.contactString;
import static cn.prinf.demos.junit.basic.AssertPractise.helloAndNow;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.describedAs;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AssertPractiseTest {

    @Test
    public void assert_array_equals() {
        int[] input = {1, 2, 5, 7, 0};
        Arrays.sort(input);

        int[] expected = {0, 1, 2, 5, 7};
        assertArrayEquals(expected, input);
    }

    @Test
    public void assert_not_null() {
        assertNotNull("should not be null", Integer.valueOf("10"));
    }


    @Test
    public void should_be_certain_type() {
        assertThat("", isA(String.class));
    }

    @Test
    public void should_start_with_hello() {

        assertThat(helloAndNow(), startsWith("Hello"));
    }

    /**
     * assert with hamcrest
     */

    @Test
    public void assert_anything() {
        assertThat("hamcrest", anything());
    }

    @Test
    public void assert_described_as() {
        assertThat("hamcrest", describedAs("a description", anything()));
    }

    @Test
    public void assert_is() {
        assertThat("hamcrest", is(anything()));
    }

    @Test
    public void assert_all_of() {
        assertThat("hamcrest", allOf(anything(), anything(), anything()));
    }

    @Test
    public void assert_any_of() {
        assertThat("hamcrest", anyOf(anything(), anything(), anything()));
    }

    @Test
    public void assert_not() {
        assertThat("hamcrest", not(not(anything())));
    }


    @Test
    public void assert_equal() {
        assertThat("hamcrest", equalTo("hamcrest"));
    }

    @Test
    public void assert_to_string() {
        assertThat("hamcrest", instanceOf(String.class));
    }


    @Test
    public void assert_be_same() {
        assertThat(Runtime.getRuntime(), sameInstance(Runtime.getRuntime()));
    }

    @Test
    public void assert_null() {
        assertThat(null, nullValue());
    }

    @Test
    public void assert_contain_items() {
        assertThat(Arrays.asList(1, 2, 3), hasItems(1, 2));
    }


    @Test
    public void should_get_error_for_null_input() {
        contactString(null, "");
    }

    @Test
    public void should_assert_with_float_delta() {
        assertEquals(3.3333F, calculateAA(10F, 3F), 0.1);
    }

    @Test
    public void should_be_true() {
        String hello = "Hello";
        assertTrue(hello.isEmpty());
    }
}
