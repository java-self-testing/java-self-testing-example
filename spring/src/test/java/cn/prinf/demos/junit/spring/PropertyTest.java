package cn.prinf.demos.junit.spring;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ContextConfiguration(initializers = PropertyTest.MyPropertyInitializer.class)

public class PropertyTest {

    @Autowired
    private ApplicationContext context;

    @Value("${testProperty}")
    private String testProperty;

    @Test
    public void test() {
        assertThat(testProperty).isEqualTo("foo");
        assertThat(this.context.getEnvironment().getProperty("testProperty")).isEqualTo("foo");
    }

    static class MyPropertyInitializer
            implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {
            TestPropertyValues.of("testProperty=foo").applyTo(applicationContext);
        }
    }
}
