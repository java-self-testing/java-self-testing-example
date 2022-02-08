package cn.prinf.demos.junit.spring;

import cn.prinf.demos.junit.spring.controller.UserController;
import cn.prinf.demos.junit.spring.entity.User;
import cn.prinf.demos.junit.spring.service.UserService;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.Instant;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class TestForController {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @Test
    public void should_list_users() throws Exception {
        Instant createAndUpdateInstant = Instant.parse("2021-11-07T00:55:32.026Z");
        given(this.userService.listAll())
                .willReturn(Lists.newArrayList(new User(1L, "James", "123456", createAndUpdateInstant, createAndUpdateInstant)));

        this.mvc.perform(MockMvcRequestBuilders.get("/users")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andExpect(
                content().string("[{\"id\":1,\"username\":\"James\",\"password\":\"123456\",\"createAt\":\"2021-11-07T00:55:32.026Z\",\"updateAt\":\"2021-11-07T00:55:32.026Z\"}]")
        );
    }
}
