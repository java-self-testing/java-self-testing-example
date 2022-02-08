package cn.prinf.demos.junit.basic;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        HelloWorldTest.class,
        AssertPractiseTest.class
})
public class SuitesPractiseTest {

}
