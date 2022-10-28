package cn.prinf.demos.junit.api;

import com.google.common.io.Resources;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import static io.restassured.RestAssured.given;

public class FileTest {

    @Test
    public void file_test() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file1 = new File(classLoader.getResource("file/test.pdf").getFile());
        System.out.println(file1);

        String file2 = Resources.getResource("file/test.pdf").getFile();
        System.out.println(file2);

        String string = Resources.toString(Resources.getResource("file/test.txt"), Charset.defaultCharset());
        System.out.println(string);
    }

    @Test
    public void upload_example() throws IOException {
        // 上传示例1
        given()
                .multiPart(new File(Resources.getResource("file/test.pdf").getFile()))
                .when().post("/upload");

        // 上传示例2
        given()
                .multiPart("custom_file_name",
                        new File(Resources.getResource("file/test.pdf").getFile())
                )
                .when().post("/upload");
    }
}
