package cn.printf.demos.tdd;

import org.junit.Assert;
import org.junit.Test;

import static cn.printf.demos.tdd.AvatarTextUtil.generateDefaultAvatarText;

public class AvatarTextUtilTest {
    @Test
    public void should_generate_user_avatar_text_for_zh() {
        User user = new User() {{
            setCnName("王老五");
            setEnName("Mike");
        }};
        Assert.assertEquals("老五", generateDefaultAvatarText(user));
    }

    @Test
    public void should_generate_user_avatar_text_for_en() {
        User user = new User() {{
            setCnName(null);
            setEnName("Mike");
        }};
        Assert.assertEquals("M", generateDefaultAvatarText(user));
    }

    @Test
    public void should_not_generate_user_avatar_text_for_empty_user_info() {
        User user = new User() {{
            setCnName(null);
            setEnName(null);
        }};
        Assert.assertEquals(null, generateDefaultAvatarText(user));
    }
}
