package cn.prinf.demos.junit.spring.service;

import cn.prinf.demos.junit.spring.entity.User;
import cn.prinf.demos.junit.spring.mapper.UserMapper;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class UserService {

    public static final String KEY = "ea416ed0759d46a8de58f63a59077499";

    @Autowired
    private UserMapper userMapper;

    public User add(User user) {
        user.setCreateAt(Instant.now());
        user.setUpdateAt(Instant.now());
        user.setPassword(hash(user.getPassword()));
        userMapper.insert(user);

        return user;
    }

    public List<User> listAll() {
        return userMapper.selectAll();
    }

    private String hash(String text) {
        return new HmacUtils(HmacAlgorithms.HMAC_SHA_512, KEY).hmacHex(text);
    }
}
