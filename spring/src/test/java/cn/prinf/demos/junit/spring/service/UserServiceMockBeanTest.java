package cn.prinf.demos.junit.spring.service;

import cn.prinf.demos.junit.spring.entity.User;
import cn.prinf.demos.junit.spring.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServiceMockBeanTest {

    @Autowired
    private UserService userService;

    @MockBean
    // 注意，要求 UserMapper 没有被定义过才能被模拟，由于这个项目有其它演示文件，无法做到
    private UserMapper userMapper;

    @Test
    public void should_list_users() {
        userService.listAll();
        Mockito.verify(userMapper).selectAll();
    }

    @Test
    public void should_add_user() {
        User user = new User() {{
            setUsername("zhangsan");
            setPassword("123456");
        }};

        userService.add(user);

        ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
        Mockito.verify(userMapper).insert(argument.capture());

        assertEquals("zhangsan", argument.getValue().getUsername());
        assertEquals("667f1213e4a57dbee7cd9e8993b82adef1032f7681a5d5c941c30281f90e7eceba629cc9ccf3f133fb478f3f54d9537c2dd50895380f659370c2a14147449ac4", argument.getValue().getPassword());
        assertNotNull(argument.getValue().getCreateAt());
        assertNotNull(argument.getValue().getUpdateAt());
    }
}
