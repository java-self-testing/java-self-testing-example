package cn.printf.demos.featuretoggles.replication;

import org.springframework.stereotype.Service;

@Service
public class EchoSaverV1 implements EchoSaver {
    @Override
    public void save(String content) {
        System.out.println("v1 saved");
    }
}
