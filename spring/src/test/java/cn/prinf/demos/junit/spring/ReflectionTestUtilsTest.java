package cn.prinf.demos.junit.spring;

import cn.prinf.demos.junit.spring.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ReflectionTestUtilsTest {
    @Test
    void visit_private_member() {
        User user = new User() {{
            setUsername("zhangsan");
            setPassword("123456");
        }};

        ReflectionTestUtils.setField(user, "username", "wang");
        assertThat(user.getUsername(), equalTo("wang"));

        assertThat(ReflectionTestUtils.getField(user, "username"), equalTo("wang"));

        assertThat(
                ReflectionTestUtils.invokeMethod(user, "testPrivateMethod"),
                equalTo("this is private method")
        );
    }
}
