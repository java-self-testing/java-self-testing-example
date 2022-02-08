package cn.printf.demos.tdd;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

import static cn.printf.demos.tdd.ImageUtil.watermarkImage;
import static org.junit.Assert.*;

public class ImageUtilTest {

    @Test
    public void should_generate_wager_mark_image() {
        Assert.assertEquals("data:image/jpg;base64,/9j/4AAQSkZJRgABAgAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0a\n" +
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
                "oWdZ/wDACX/4mquoeHta0mBZ9S0fULOFm2LJc2zxqWwTjLADOAePavZrC5srTwFq91N8UdTuLa+u\n" +
                "YbSDUntrnfaypmRlVSxb5l4JGB7npXnnxCh1PTJ9Osp/Feoa9YXlnFqED3LSKuHLhTsdmwcDrwfm\n" +
                "xXVg8yq163s5JLW3wzV7JN2uktL2s9dBSgkrnFUUUV7ZkFXtH1i/0DVYdT0yfyLyDd5cmxW27lKn\n" +
                "hgR0J7VRoqZRjOLjJXTGe26N8TIr7wdZQ3nji50XXIp5jdSyaaLtbhWcsMDaQAAQBgrjBG3G0jD1\n" +
                "/W/Cl5p9raat4r1zxG8uoPdXM9tHJB5MflMFRIpW8sHewIIXhdw44B8uoryYZLQp1HOm2rtvRRW/\n" +
                "ny81l0Vy3UbVmeo3PiX4b3HhSy8OCLxTFYW07XJMUVqJJpDkBpG7kAlRjHGM5wMZ3jTxB4K1/SrT\n" +
                "+zo9fTUdPsYbC0+0LCImjjbq+0k7tpbpgZxxXn9FbU8rpU5qalK6be/V7/eJzbVgooor0iAooooA\n" +
                "KKKKACiiigAooooA/9k=", watermarkImage("老五", Color.BLUE));
    }
}
