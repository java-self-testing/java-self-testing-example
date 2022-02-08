package cn.printf.demos.featuretoggles.javanative;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

    @Value("${app.features.helloEchoEnabled}")
    private boolean helloEchoEnabled;

    @GetMapping("/hello")
    public String echo() {
        if (helloEchoEnabled) {
            return "Hello World!";
        } else {
            return null;
        }
    }
}
