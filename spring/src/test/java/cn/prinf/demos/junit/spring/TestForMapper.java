package cn.prinf.demos.junit.spring;

import cn.prinf.demos.junit.spring.entity.User;
import cn.prinf.demos.junit.spring.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;

@MybatisTest
public class TestForMapper {

    @Autowired
    private UserMapper userMapper;

    @Test
    void should_save_user() {
        User user = new User() {{
            setUsername("zhangsan");
            setPassword("123456");
            setCreateAt(Instant.now());
            setUpdateAt(Instant.now());
        }};
        userMapper.insert(user);
    }
}
