package cn.prinf.demos.junit.api;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.ok;
import static com.github.tomakehurst.wiremock.client.WireMock.okJson;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.temporaryRedirect;
import static com.github.tomakehurst.wiremock.client.WireMock.unauthorized;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.verify;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

public class UserMockServerTest extends TestBase {

    private WireMockServer wireMockServer;

    @Autowired
    RestTemplate restTemplate;

    @BeforeEach
    public void setUp() {
        super.setUp();
        wireMockServer = new WireMockServer(options().port(9090));
        wireMockServer.start();
    }

    @AfterEach
    void tearDown() {
        wireMockServer.stop();
    }

    @Test
    void test_mock_server() {
        configureFor("localhost", 9090);
        stubFor(get(urlEqualTo("/users"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "text/json")
                        .withBody("{\"name\":\"john\"}")));

        String response = restTemplate.getForObject("http://localhost:9090/users", String.class);
        System.out.println(response);
    }

    @Test
    void test_mock_json() {
        configureFor("localhost", 9090);
        stubFor(get("/users")
                .willReturn(okJson("{\"name\":\"john\"}")));

        String response = restTemplate.getForObject("http://localhost:9090/users", String.class);
        Assertions.assertEquals("{\"name\":\"john\"}", response);
    }

    @Test
    void mock_status() {
        configureFor("localhost", 9090);
        stubFor(get("/limited-resources")
                .willReturn(unauthorized()));

        Assertions.assertThrows(HttpClientErrorException.Unauthorized.class, () -> {
            restTemplate.getForEntity("http://localhost:9090/limited-resources", String.class);
        });
    }

    @Test
    void mock_redirect() {
        configureFor("localhost", 9090);
        stubFor(get("/redirect-to")
                .willReturn(ok("new-url")));
        stubFor(get("/redirect")
                .willReturn(temporaryRedirect("/redirect-to")));

        String response = restTemplate.getForObject("http://localhost:9090/redirect-to", String.class);
        Assertions.assertEquals(response, "new-url");
    }

    @Test
    void verify_mock_server() {
        // 准备 Mock 数据
        configureFor("localhost", 9090);
        stubFor(get(urlEqualTo("/users"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "text/json")
                        .withBody("{\"name\":\"john\"}")));

        // 调用被测试内容
        String response = restTemplate.getForObject("http://localhost:9090/users", String.class);
        System.out.println(response);

        // 验证被依赖 API
        verify(getRequestedFor(urlEqualTo("/users"))
                .withHeader("Content-Type", equalTo("text/json")));
    }
}
