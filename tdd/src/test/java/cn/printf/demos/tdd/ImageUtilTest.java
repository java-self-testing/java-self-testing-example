package cn.printf.demos.tdd;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

import static cn.printf.demos.tdd.ImageUtil.watermarkImage;
import static org.junit.Assert.*;

public class ImageUtilTest {

    @Test
    public void should_generate_watermark_image() {
        Assert.assertEquals("data:image/jpeg;base64,/9j/4AAQSkZJRgABAgAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0a\n" +
                "HBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIy\n" +
                "MjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCAA8ADwDASIA\n" +
                "AhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQA\n" +
                "AAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3\n" +
                "ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWm\n" +
                "p6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEA\n" +
                "AwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSEx\n" +
                "BhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElK\n" +
                "U1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3\n" +
                "uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwDxyiii\n" +
                "v3E8wKKKKACiiigAooooAKKKvaP/AGV/asP9t/bf7O+bzvsW3zfunbt3cfexnPbNTKXLFytewwtd\n" +
                "Hv73Sr/U7eDfZ6f5f2mTeo8vzG2pwTk5I7A+9Mg0vULmCOeCxuZYZZxbRyRwsyvMRkRggYLEfw9a\n" +
                "+n7PXRD4bu9Q1nVtf0a2fb5NxrENnDKCu4sscaoSWIU8MhJGNo71538U/F1vq1jayPZ+L9Hv4GEm\n" +
                "nxXUCW8BkVhukPO8sFOAQflJHTJz85hc7xGIr+yVJWva6bdtF5K+u9tluur1lTSV7nmv/CF+Kv8A\n" +
                "oWdZ/wDACX/4mquoeHta0mBZ9S0fULOFm2LJc2zxqWwTjLADOAePavarG7020+HeqXMnxO1adL28\n" +
                "jtI9UeC4zbOmJNiJneCy7stkAggdufOPiFDqemT6dZT+K9Q16wvLOLUIHuWkVcOXCnY7Ng4HXg/N\n" +
                "iunB5lWr1vZySWrXwzV7JN2urfJ6ilBJXOKooor3DIKvaPrF/oGqw6npk/kXkG7y5Nitt3KVPDAj\n" +
                "oT2qjRUyjGcXGSumM9t0b4mRX3g6yhvPHFzouuRTzG6lk00Xa3Cs5YYG0gAAgDBXGCNuNpGHr+t+\n" +
                "FLzT7W01bxXrniN5dQe6uZ7aOSDyY/KYKiRSt5YO9gQQvC7hxwD5dRXkwyWhTqOdNtXbeiit/Pl5\n" +
                "rLorluo2rM9Yu/F/w6vPBVh4Ukh8UiwspzPHIq2/mliXOCd2MfvG7DoKx/GniDwVr+lWn9nR6+mo\n" +
                "6fYw2Fp9oWERNHG3V9pJ3bS3TAzjivP6K1pZVSpTU4yldNvfq9/v6ic21YKKKK9MgKKKKACiiigA\n" +
                "ooooAKKKKAP/2Q==", watermarkImage("老五", Color.BLUE));
    }
}
