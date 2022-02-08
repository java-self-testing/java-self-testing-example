package cn.prinf.demos.junit.api.controller;

import cn.prinf.demos.junit.api.controller.dto.AddUserRequest;
import cn.prinf.demos.junit.api.entity.User;
import cn.prinf.demos.junit.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.listAll());
    }

    @PostMapping("")
    public ResponseEntity addUser(@RequestBody AddUserRequest addUserRequest) {
        User savedUser = userService.add(addUserRequest);
        return ResponseEntity.created(
                URI.create("/api/users/" + savedUser.getId())
        ).build();
    }
}
