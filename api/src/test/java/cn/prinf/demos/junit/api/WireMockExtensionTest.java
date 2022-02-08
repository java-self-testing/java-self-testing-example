package cn.prinf.demos.junit.api;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

public class WireMockExtensionTest extends TestBase {
    @RegisterExtension
    WireMockExtension wireMock = new WireMockExtension();

    @Autowired
    RestTemplate restTemplate;

    @Test
    void test() throws IOException {
        configureFor("localhost", 8080);
        wireMock.stubFor(get(urlEqualTo("/users"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "text/json")
                        .withBody("{\"name\":\"john\"}")));

        String response = restTemplate.getForObject("http://localhost:8080/users", String.class);
        Assertions.assertEquals("{\"name\":\"john\"}", response);
    }
}
