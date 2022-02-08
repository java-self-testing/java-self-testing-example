package cn.printf.concurrence;

import com.google.code.tempusfugit.concurrency.ConcurrentRule;
import com.google.code.tempusfugit.concurrency.DeadlockDetector;
import org.junit.Rule;
import org.junit.Test;

public class DeadLockTest {

    @Rule
    public ConcurrentRule rule = new ConcurrentRule();

    @Test
    public void noDeadlock() {
        DeadlockDetector.printDeadlocks(System.out);
    }

    @Test(timeout = 1000)
    public void runsMultipleTimes() {
        DeadLockExample.startBusiness();
    }
}
