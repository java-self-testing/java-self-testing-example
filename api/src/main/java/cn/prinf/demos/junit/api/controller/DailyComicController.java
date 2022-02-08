package cn.prinf.demos.junit.api.controller;

import cn.prinf.demos.junit.api.adapter.xkcd.XkcdClient;
import cn.prinf.demos.junit.api.adapter.xkcd.XkcdVO;
import cn.prinf.demos.junit.api.controller.dto.DailyComicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/daily-comic")
public class DailyComicController {

    @Autowired
    private XkcdClient xkcdClient;

    @GetMapping("")
    public ResponseEntity<DailyComicResponse> getCurrentComic() {
        XkcdVO xkcdVO = xkcdClient.getXkcdResponse();
        return ResponseEntity.ok(
                DailyComicResponse.builder().imageLink(xkcdVO.getImg()).build()
        );
    }

}
