package cn.prinf.demos.junit.spring.embedded;

import org.junit.jupiter.api.Test;

public class RedisEmbeddedTest extends SpringBaseTest {
    @Test
    public void should_started_redis() {
        System.out.println("Redis ports:" + redisServer.ports());
    }
}
