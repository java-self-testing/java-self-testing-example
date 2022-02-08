package cn.printf.concurrence;

import com.google.code.tempusfugit.concurrency.ConcurrentRule;
import com.google.code.tempusfugit.concurrency.RepeatingRule;
import com.google.code.tempusfugit.concurrency.annotations.Concurrent;
import com.google.code.tempusfugit.concurrency.annotations.Repeating;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RunConcurrentlyTest {

    @Rule
    public ConcurrentRule concurrently = new ConcurrentRule();
    @Rule
    public RepeatingRule repeatedly = new RepeatingRule();

    private static int counter = 0;

    @Test
    @Concurrent(count = 100)
    @Repeating(repetition = 1000)
    public void runsMultipleTimes() {
        RunConcurrentlyTest.counter++;
    }

    @AfterClass
    public static void annotatedTestRunsMultipleTimes() {
        assertEquals(counter, 100000);
    }
}
