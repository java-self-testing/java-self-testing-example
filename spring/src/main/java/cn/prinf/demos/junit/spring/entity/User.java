package cn.prinf.demos.junit.spring.entity;

import java.io.Serializable;
import java.time.Instant;

public class User implements Serializable {
    private long id;
    private String username;
    private String password;
    private Instant createAt;
    private Instant updateAt;

    public User() {
    }

    public User(long id, String username, String password, Instant createAt, Instant updateAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Instant getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Instant createAt) {
        this.createAt = createAt;
    }

    public Instant getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Instant updateAt) {
        this.updateAt = updateAt;
    }

    private String testPrivateMethod() {
        return "this is private method";
    }
}
