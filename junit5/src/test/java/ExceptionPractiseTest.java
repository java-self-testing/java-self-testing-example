import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionPractiseTest {

    @Test
    void should_got_exception_when_the_dividend_is_0() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            int result = 10 / 0;
        });
    }
}
