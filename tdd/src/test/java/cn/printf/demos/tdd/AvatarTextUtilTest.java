package cn.printf.demos.tdd;

import org.junit.Assert;
import org.junit.Test;

import static cn.printf.demos.tdd.AvatarTextUtil.generatorDefaultAvatarText;

public class AvatarTextUtilTest {
    @Test
    public void should_generated_user_avatar_text_for_zh() {
        User user = new User() {{
            setCnName("王老五");
            setEnName("Mike");
        }};
        Assert.assertEquals("老五", generatorDefaultAvatarText(user));
    }

    @Test
    public void should_generated_user_avatar_text_for_en() {
        User user = new User() {{
            setCnName(null);
            setEnName("Mike");
        }};
        Assert.assertEquals("M", generatorDefaultAvatarText(user));
    }

    @Test
    public void should_not_generated_user_avatar_text_for_empty_user_info() {
        User user = new User() {{
            setCnName(null);
            setEnName(null);
        }};
        Assert.assertEquals(null, generatorDefaultAvatarText(user));
    }
}
