package cn.prinf.demos.junit.sourceanalysis2;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.AnyOf.anyOf;

public class HelloWorldTest {

    @Test
    public void should_return_world_as_string() {

        assertThat(HelloWorld.hello(), anyOf(is("Hello, world!"), is("Hello, world2!")));

    }
}
