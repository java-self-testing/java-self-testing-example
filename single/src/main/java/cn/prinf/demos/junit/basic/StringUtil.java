package cn.prinf.demos.junit.basic;

public class StringUtil {
    public static String upperCaseFirst(String val) {
        char[] arr = val.toCharArray();
        arr[0] = Character.toUpperCase(arr[0]);
        return new String(arr);
    }

    public static void main(String[] args) {
        String val1 = "java";
        String val2 = "advanced java";
        String val3 = "测试";

        String output = upperCaseFirst(val1);
        System.out.println(val1);
        System.out.println(output);

        output = upperCaseFirst(val2);
        System.out.println(val2);
        System.out.println(output);

        output = upperCaseFirst(val3);
        System.out.println(val3);
        System.out.println(output);
    }
}
