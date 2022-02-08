package cn.printf.demos.featuretoggles.replication;

import org.springframework.stereotype.Service;

@Service
public class EchoSaverV2 implements EchoSaver{
    @Override
    public void save(String content) {
        System.out.println("v2 saved");
    }
}
