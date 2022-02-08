package cn.prinf.demos.junit.basic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloWorldTest {

    @Test
    public void should_return_world_as_string() {
        assertEquals("Hello, world!",HelloWorld.hello());
    }
}
