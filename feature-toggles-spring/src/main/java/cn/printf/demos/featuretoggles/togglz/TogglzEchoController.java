package cn.printf.demos.featuretoggles.togglz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.togglz.core.manager.FeatureManager;

import static cn.printf.demos.featuretoggles.togglz.MyFeatures.EXPERIMENT;
import static cn.printf.demos.featuretoggles.togglz.MyFeatures.HELLO_WORLD;

@RestController
public class TogglzEchoController {
    @Autowired
    private FeatureManager manager;

    @RequestMapping("/hello3")
    public String hello3() {
        if (manager.isActive(HELLO_WORLD)) {
            return "Hello world3!";
        }
        return null;
    }

    @RequestMapping("/hello4")
    public String hello4() {
        if (manager.isActive(EXPERIMENT)) {
            return "Hello world4!";
        }
        return null;
    }
}
