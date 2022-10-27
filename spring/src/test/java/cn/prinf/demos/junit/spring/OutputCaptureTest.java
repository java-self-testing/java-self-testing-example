package cn.prinf.demos.junit.spring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(OutputCaptureExtension.class)
public class OutputCaptureTest {
    @Test
    public void test_capture(CapturedOutput output) throws Exception {
        System.out.println("Hello World!");
        assertThat(output).contains("World");
    }
}
