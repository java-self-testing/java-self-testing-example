package cn.prinf.demos.junit.spring.controller;

import cn.prinf.demos.junit.spring.entity.User;
import cn.prinf.demos.junit.spring.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.Instant;
import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @Test
    public void should_list_users() throws Exception {
        given(userService.listAll()).willReturn(
                Arrays.asList(new User() {{
                    setId(01L);
                    setUsername("Test user");
                    setPassword("123456");
                    setCreateAt(Instant.now());
                    setUpdateAt(Instant.now());
                }})
        );


        // 简写版本
        // this.mvc.perform(get("/users").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .get("/users")
                .accept(MediaType.APPLICATION_JSON);

        ResultActions actions = this.mvc.perform(builder);
        ResultMatcher okMatcher = status().isOk();
        actions.andExpect(okMatcher);
    }
}
