package cn.printf.demos.featuretoggles;

import cn.printf.demos.featuretoggles.provider.Echo;
import java.util.ServiceLoader;


public class ProviderVersion {
    public static void main(String[] args) {
        Echo echoService = ServiceLoader.load(Echo.class).iterator().next();
        echoService.echoHello();
    }
}
