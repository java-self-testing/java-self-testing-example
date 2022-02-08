package cn.printf.demos.loggable;


import com.github.rozidan.springboot.logger.Loggable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @Loggable
    @GetMapping
    public String hello() {
        return helloService.hello("zhangsan");
    }
}
