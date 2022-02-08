package cn.printf.demos.featuretoggles.togglz;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.togglz.core.activation.Parameter;
import org.togglz.core.activation.ParameterBuilder;
import org.togglz.core.repository.FeatureState;
import org.togglz.core.spi.ActivationStrategy;
import org.togglz.core.user.FeatureUser;

import javax.servlet.http.HttpServletRequest;

public class HeaderParameterActivationStrategy implements ActivationStrategy {

    public static final String HEADER_PARAMETER = "header-parameter";
    public static final String HEADER_PARAMETER_ACTIVATION_STRATEGY = "Header Parameter Activation Strategy";

    @Override
    public String getId() {
        return HEADER_PARAMETER;
    }

    @Override
    public String getName() {
        return HEADER_PARAMETER_ACTIVATION_STRATEGY;
    }

    @Override
    public boolean isActive(FeatureState featureState, FeatureUser featureUser) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        if (request == null) {
            return false;
        }
        String key = featureState.getParameter("key");
        String secret = featureState.getParameter("secret");
        return request.getHeader(key).equals(secret);
    }

    @Override
    public Parameter[] getParameters() {
        return new Parameter[]{
                ParameterBuilder.create("key").label("Key in header"),
                ParameterBuilder.create("secret").label("Secret in header")
        };
    }
}
