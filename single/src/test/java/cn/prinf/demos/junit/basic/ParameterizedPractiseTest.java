package cn.prinf.demos.junit.basic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static cn.prinf.demos.junit.basic.UseCaseDesignPractiseTest.isPalindrome;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedPractiseTest {
    @Parameterized.Parameters(name = "{index}_input_({0})_should_be_{1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Integer.MIN_VALUE, false},
                {0, true},
                {5, true},
                {10, false},
                {11, true},
                {Integer.MAX_VALUE, false}
        });
    }

    private int input;

    private boolean expected;

    public ParameterizedPractiseTest(int input, boolean expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() {
        assertEquals(expected, isPalindrome(input));
    }
}
