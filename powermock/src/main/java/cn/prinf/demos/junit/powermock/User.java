package cn.prinf.demos.junit.powermock;

import java.time.Instant;

public class User {
    private String email;
    private String username;
    private String password;
    private Instant createAt;

    public User(String email, String username, String password, Instant createAt) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.createAt = createAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
