package cn.prinf.demos.junit.spring.embedded;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import redis.embedded.RedisServer;

public class SpringBaseTest {

    static RedisServer redisServer;

    @BeforeAll
    public static void setup() throws Exception {
        redisServer = new RedisServer(6379);
        redisServer.start();
    }

    @AfterAll
    public static void teardown() throws Exception {
        redisServer.stop();
    }
}
