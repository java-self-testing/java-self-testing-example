package cn.prinf.demos.junit.api.adapter.xkcd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class XkcdClient {
    @Autowired
    private RestTemplate restTemplate;

    public XkcdVO getXkcdResponse() {
        return restTemplate.getForObject("https://xkcd.com/info.0.json", XkcdVO.class);
    }
}
