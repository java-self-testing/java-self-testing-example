package cn.prinf.demos.junit.basic;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class GlobalTimeoutPractiseTest {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(10);

    @Test
    public void test_sleep_11_seconds() throws Exception {
        Thread.sleep(11000);
    }

    @Test
    public void test_sleep_12_seconds() throws Exception {
        Thread.sleep(12000);
    }
}
