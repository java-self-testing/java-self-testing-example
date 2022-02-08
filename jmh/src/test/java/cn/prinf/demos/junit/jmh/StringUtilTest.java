package cn.prinf.demos.junit.jmh;

import com.carrotsearch.junitbenchmarks.AbstractBenchmark;
import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkMethodChart;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@BenchmarkOptions(benchmarkRounds = 10000, callgc = false, warmupRounds = 5)
@BenchmarkMethodChart(filePrefix = "StringUtil test")
public class StringUtilTest  extends AbstractBenchmark {

    @Test
    public void repeat_string() {
        assertEquals(
                "HelloHelloHelloHelloHelloHelloHelloHelloHelloHello",
                StringUtil.repeatString("Hello",10)
        );
    }

    @Test
    public void repeat_string_with_builder() {
        assertEquals(
                "HelloHelloHelloHelloHelloHelloHelloHelloHelloHello",
                StringUtil.repeatStringWithBuilder("Hello",10)
        );
    }
}
