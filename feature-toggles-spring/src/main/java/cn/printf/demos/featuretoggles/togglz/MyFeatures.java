package cn.printf.demos.featuretoggles.togglz;

import org.togglz.core.Feature;
import org.togglz.core.annotation.EnabledByDefault;
import org.togglz.core.annotation.Label;

public enum MyFeatures implements Feature {

    @EnabledByDefault
    @Label("Hello World")
    HELLO_WORLD,

    @EnabledByDefault
    @Label("Experiment")
    EXPERIMENT,
}
