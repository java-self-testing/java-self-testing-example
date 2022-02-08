package cn.printf.demos.featuretoggles.javanative;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@ConditionalOnProperty("app.features.helloEchoEnabled")
@RestController
public class DynamicEchoController {
    @GetMapping("/hello2")
    public String hello2() {
        return "Hello World!";
    }
}
