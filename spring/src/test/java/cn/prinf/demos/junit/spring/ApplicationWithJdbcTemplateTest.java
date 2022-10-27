package cn.prinf.demos.junit.spring;

import cn.prinf.demos.junit.spring.entity.User;
import cn.prinf.demos.junit.spring.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.jdbc.JdbcTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = {Application.class}, value = {"server.port=9090"}, properties = {"server.port=9090"})
public class ApplicationWithJdbcTemplateTest {

    @Autowired
    private UserService userService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void should_add_user() {
        User user = new User() {{
            setUsername("zhangsan");
            setPassword("123456");
        }};

        userService.add(user);
        int count = JdbcTestUtils.countRowsInTable(jdbcTemplate, "user");
        assertEquals(1, count);
    }
}
