package cn.prinf.demos.junit.spring;

import cn.prinf.demos.junit.spring.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;
import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@JsonTest
public class TestForJson {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void should_serialize_properly() throws JsonProcessingException {
        User user = new User() {{
            setUsername("zhangsan");
            setPassword("123456");
            setCreateAt(Instant.now());
            setUpdateAt(Instant.now());
        }};
        // 使用下面的断言可能因为时间跑不过，所以不能直接断言 JSON 文本，推荐下面的断言方法
        assertEquals("{\"id\":0,\"username\":\"zhangsan\",\"password\":\"123456\",\"createAt\":\"2021-11-07T02:00:45.126Z\",\"updateAt\":\"2021-11-07T02:00:45.126Z\"}", this.objectMapper.writeValueAsString(user));
    }


    @Autowired
    private JacksonTester<User> userJacksonTester;

    @Test
    void should_serialize_properly_with_tester() throws IOException {
        User user = new User() {{
            setUsername("zhangsan");
            setPassword("123456");
            setCreateAt(Instant.now());
            setUpdateAt(Instant.now());
        }};
        assertThat(this.userJacksonTester.write(user)).hasJsonPath("@.username");
        assertThat(this.userJacksonTester.write(user))
                .extractingJsonPathStringValue("@.username")
                .isEqualTo("zhangsan");
    }
}
