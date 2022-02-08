package cn.prinf.demos.junit.basic;

import org.junit.Test;

import static cn.prinf.demos.junit.basic.StringUtil.upperCaseFirst;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class StringUtilTest {

    @Test
    public void should_make_first_case_upper() {
        // given
        String inputString = "test";
        // when
        String result = upperCaseFirst(inputString);
        // then
        assertThat(result, equalTo("Test"));
    }

}
