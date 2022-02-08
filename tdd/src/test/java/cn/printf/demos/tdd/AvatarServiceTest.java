package cn.printf.demos.tdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AvatarServiceTest {
    AvatarService avatarService = null;

    @Before
    public void setUp() throws Exception {
        avatarService = new AvatarService();
    }

    @Test
    public void generate_user_default_avatar_for_male() {
        User user = new User() {{
            setCnName("王老五");
            setEnName("Mike");
            setGender("male");
        }};
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
                "KKKKACiiigAooooA/9k=", avatarService.generateUserDefaultAvatar(user));
    }

    @Test
    public void generate_user_default_avatar_for_female() {
        User user = new User() {{
            setCnName("王丽丽");
            setEnName("Mike");
            setGender("female");
        }};
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
                "uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwDi6KKK\n" +
                "+ZP3EKKKKACiiigAooooAKmtbW4vbhLe0t5Z53ztjiQuzYGTgDnoCahrU8NxrN4p0iJiwV72FSUc\n" +
                "q2C46EYIPuOacVdpGdWfJTlNdE2O/wCEW8Q/9AHVP/AOT/Cj/hFvEP8A0AdU/wDAOT/CvoGDw9E3\n" +
                "m/aGv48SER+XrN0+5OxOWGD7c49TXJeI9PjeDQJT9qVJdatER11aa4SVGTcXQluPmLAMAD8uRjNd\n" +
                "88Eoq9/6+4+Tw/E0q1TkUf6/8CPK/wDhFvEP/QB1T/wDk/wqK60DWbK3e4u9Iv4IExukltnRVycD\n" +
                "JIx1IFfQ0Hh6JvN+0Nfx4kIj8vWbp9ydicsMH25x6mvP/iPZong+3ugJwGvYhG51OW7ilRoSxZd7\n" +
                "YxuJUHAJC54DYpVMGoQcr/19xpguI5YnERo8trtL+ve/zPKKKKK4D6wK0dAuobLxHpd3cPsggu4p\n" +
                "JGwTtVXBJwOegrOopp2dyKkFODg+uh7boXxC8O6dBcx3WrtIJ9RuZY1W1cCCJndlycfMD17kGQDG\n" +
                "AccwPFenpoXhaxuNYa9ltNRtrmUi0Ma2kMagGM8fORk8jOcH2z5zRXQ8XNpI8anw/hac3NN6u/Tz\n" +
                "Xbz+fW+p7boXxC8O6dBcx3WrtIJ9RuZY1W1cCCJndlycfMD17kGQDGAccPr3iG1uvh/pWjf2q2oX\n" +
                "kc0cpAtvKW2jWLb5RP8AGQSfmGc4Oe2eKopTxU5R5WVh8iw1Cr7aLd7p9N1fyv16b9QooornPaCi\n" +
                "iigAooooAKKKKACiiigD/9k=", avatarService.generateUserDefaultAvatar(user));
    }

    @Test
    public void generate_user_default_avatar_for_null_gender() {
        User user = new User() {{
            setCnName("王丽丽");
            setEnName("Mike");
            setGender(null);
        }};
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
                "uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwAooooA\n" +
                "KKKKACiiigAooooAKkggmuZlht4pJZW+6kalmPfgCo6vaKgk13T0YsA1zGCVYqeWHQjkfUUAO/sL\n" +
                "WP8AoFX3/gO/+FH9hax/0Cr7/wAB3/wr1uLSIzv843aYchNmpTtlexOWGD7c/Wuf1m0RotJkPnhZ\n" +
                "NTt1VhqEkyurLkspJ45JAPB4zxmgDhP7C1j/AKBV9/4Dv/hUc+k6lbQtNcafdxRL955IWVR25JFe\n" +
                "vxaRGd/nG7TDkJs1Kdsr2Jywwfbn61yXjO3VfDsM4EuGuUCMb6S4SRTEW3LuOOpIBxnjPegDgaKK\n" +
                "KACrmkzx22s2NxM22KK4jd2xnADAk8VTooA9N0rxfo9nFMk+oM4lvJnQCBh5SMzMMnHOevr8+McV\n" +
                "iDXrRdK0K1l1Frl7e8hnc+QUFvGigbP9rGTyM5wfbPG0UAem6V4v0ezimSfUGcS3kzoBAw8pGZmG\n" +
                "TjnPX1+fGOK5jVtYgn8I2Gm/b2u7hJEkI8jyxAgj2+Xn+LBPXvz7VzNFABRRRQAUUUUAFFFFABRR\n" +
                "RQAUUUUAf//Z", avatarService.generateUserDefaultAvatar(user));
    }
}
