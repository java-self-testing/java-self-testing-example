import cn.prinf.demos.junit.jupiter.HelloWorld;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloWorldTest {

    @Test
    public void should_return_world_as_string() {
        assertEquals("Hello, world!", HelloWorld.hello());
    }
}
