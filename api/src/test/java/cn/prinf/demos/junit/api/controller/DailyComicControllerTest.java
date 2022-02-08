package cn.prinf.demos.junit.api.controller;

import cn.prinf.demos.junit.api.TestBase;
import cn.prinf.demos.junit.api.adapter.xkcd.XkcdClient;
import cn.prinf.demos.junit.api.adapter.xkcd.XkcdVO;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

class DailyComicControllerTest extends TestBase {

    @Autowired
    private XkcdClient xkcdClient;

    @Test
    void get_current_comic() {
        BDDMockito.given(xkcdClient.getXkcdResponse()).willReturn(new XkcdVO() {{
            setImg("https://imgs.xkcd.com/comics/fuzzy_blob.png");
        }});

        given()
                .contentType("application/json")
                .when()
                .get("/daily-comic")
                .then().statusCode(200)
                .body("imageLink", is("https://imgs.xkcd.com/comics/fuzzy_blob.png"));
    }
}
