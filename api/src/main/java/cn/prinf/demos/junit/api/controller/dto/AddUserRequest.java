package cn.prinf.demos.junit.api.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AddUserRequest {
    private String name;

    private String email;

    private String password;
}
