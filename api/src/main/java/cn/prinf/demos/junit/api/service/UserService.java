package cn.prinf.demos.junit.api.service;

import cn.prinf.demos.junit.api.controller.dto.AddUserRequest;
import cn.prinf.demos.junit.api.entity.User;
import cn.prinf.demos.junit.api.repository.UserRepository;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class UserService {

    public static final String KEY = "ea416ed0759d46a8de58f63a59077499";

    @Autowired
    private UserRepository userRepository;

    public User add(AddUserRequest request) {
        User user = User.builder()
                .email(request.getEmail())
                .name(request.getName())
                .password(hash(request.getPassword()))
                .role(User.Role.USER)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build();
        userRepository.save(user);
        return user;
    }

    public List<User> listAll() {
        return userRepository.findAll();
    }

    private String hash(String text) {
        return new HmacUtils(HmacAlgorithms.HMAC_SHA_512, KEY).hmacHex(text);
    }
}
