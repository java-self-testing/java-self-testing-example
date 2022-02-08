package cn.prinf.demos.junit.basic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PreparationMethodsPractiseTest {

    StringAppender stringAppender;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("@BeforeClass");
    }

    @Before
    public void setup() {
        stringAppender = new StringAppender();
        System.out.println("@Before");
    }

    @After
    public void tearDown() {
        stringAppender = new StringAppender();
        System.out.println("@After");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("@AfterClass");
    }

    @Test
    public void should_get_text_from_object() {
        stringAppender.append("Hello");
        stringAppender.append(",world");
        assertEquals("Hello,world", stringAppender.getValue());
    }

    class StringAppender {
        private String value = "";

        public void append(String appendText) {
            value = value + appendText;
        }

        public String getValue() {
            return value;
        }
    }
}
