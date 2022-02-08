package cn.prinf.demos.junit.stubs;

import org.hamcrest.Matcher;
import org.hamcrest.core.IsNull;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.intThat;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ArgumentMatchersExampleTest {

    @Test
    public void matchers_any() {
        List mockedList = mock(List.class);
        when(mockedList.add(any())).thenReturn(true);

        System.out.println(mockedList.add(null));
    }

    @Test
    public void matchers_any_of() {
        List mockedList = mock(List.class);
        // 等价于 any(Boolean.class);
        when(mockedList.add(anyBoolean())).thenReturn(true);

        System.out.println(mockedList.add(null));
    }

    @Test
    public void matchers_null() {
        List mockedList = mock(List.class);
        // 等价 isNull
        when(mockedList.add(eq(null))).thenReturn(false);

        // 这里是在真实调用，传入字面量
        System.out.println(mockedList.add(null));

        // 这里是在 verify，仍然使用参数匹配器
        verify(mockedList).add(isNull());

        // 这里是在断言，使用断言中的匹配器
        assertThat(mockedList.get(0), nullValue());
        assertThat(mockedList.get(0), equalTo(null));
        assertThat(mockedList.get(0), new IsNull());
    }
}
