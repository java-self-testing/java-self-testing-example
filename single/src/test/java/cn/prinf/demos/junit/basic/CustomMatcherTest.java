package cn.prinf.demos.junit.basic;

import org.junit.Test;

import static cn.prinf.demos.junit.basic.CurrentSystemTimeMatcher.currentTimeEquals;
import static org.junit.Assert.*;

public class CustomMatcherTest {

    @Test
    public void should_assert_time_with_time_window() throws InterruptedException {
        long now = System.currentTimeMillis();
        assertThat(now, currentTimeEquals(10));
    }
}
