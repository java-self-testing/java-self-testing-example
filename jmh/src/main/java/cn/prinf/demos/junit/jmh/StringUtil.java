package cn.prinf.demos.junit.jmh;

public class StringUtil {

    public static String repeatString(String text, int count) {
        String out = "";
        for (int i = 0; i < count; i++) {
            out += text;
        }
        return out;
    }

    public static String repeatStringWithBuilder(String text, int count) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append(text);
        }
        return stringBuilder.toString();
    }
}
