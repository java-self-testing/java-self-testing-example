package cn.printf.demos.loggable;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloServiceTest {
    @Test
    public void should_get_hello_xxx() {
        assertEquals("Hello zhangsan", new HelloService().hello("zhangsan"));
    }
}
