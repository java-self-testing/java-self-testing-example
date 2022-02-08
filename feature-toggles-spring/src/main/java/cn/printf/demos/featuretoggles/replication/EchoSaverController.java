package cn.printf.demos.featuretoggles.replication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EchoSaverController {

    @Autowired
    private List<EchoSaver> echoSavers;

    @RequestMapping("/echoSaver")
    public void echoSaver() {
        echoSavers.forEach((saver) -> {
            saver.save("test data");
        });
    }
}
