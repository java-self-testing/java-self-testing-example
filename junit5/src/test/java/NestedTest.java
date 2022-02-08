import cn.prinf.demos.junit.jupiter.HelloWorld;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NestedTest {

    @Test
    @DisplayName("Normal test")
    public void should_return_world_as_string() {
        assertEquals("Hello, world!", HelloWorld.hello());
    }

    @Nested
    @DisplayName("Nested testing demonstration")
    class NestedInnerDemoTest {

        @Test
        void first_test() {
            System.out.println("this is first nested test");
        }


        @Test
        void second_test() {
            System.out.println("this is first nested test");
        }
    }
}
