package cn.printf.demos.featuretoggles.javanative;


import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration()
public class FeatureConfiguration {

    @Bean
    @ConditionalOnExpression("${app.features.helloEchoEnabled}")
    public EchoService echoService() {
        return new EchoService();
    }
}
