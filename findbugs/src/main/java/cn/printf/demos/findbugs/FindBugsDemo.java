package cn.printf.demos.findbugs;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindBugsDemo {

    public static void main(String[] args) {

        // find bugs case 1
        mathCalculate();

        // 无限递归调用
        infiniteRecursive();

        // 空指针问题
        nullIssue();

        // 潜在死锁问题
        deadLock();

        // 异常忘记 throw
        noThrow();

        // String 相等判定
        equalsString();

        // String 拼接
        stringConcat();

        // 忘记接返回值
        forgotReturnValue();

        // 数组不使用迭代器删除
        arrayListRemoveException();

        // 流忘记关闭
        forgotCloseStream();

        // 类型强制转换
        objectCastIssue();
    }

    private static void forgotCloseStream() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream s = null;
        // 需要关闭流
        try {
            s = new ObjectOutputStream(out);
            s.writeObject(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void objectCastIssue() {
        long number = 1000L;

        // 数据会被截断
        int number2 = (int) number;
    }

    private static void arrayListRemoveException() {
        ArrayList<String> list = new ArrayList<>();

        // 数组的移除需要在迭代中完成
        for (String item : list) {
            list.remove(item);
        }
    }

    private static void forgotReturnValue() {
        List<String> list = Arrays.asList("hello");

        // map 需要使用返回值
        list.stream().map(String::toUpperCase);

        String hello = "hello  ";
        // 字符串操作也需要返回值
        hello.trim();
    }

    private static void stringConcat() {
        String sting = "test";
        // 应该使用 String Builder
        for (int i = 0; i < 1000; i++) {
            sting += sting;
        }
    }

    private static void equalsString() {
        String sting1 = "test";
        String sting2 = "test";

        if (sting1 == sting2) {
            System.out.println("不安全的相等判定");
        }
    }

    private static void noThrow() {
        boolean condition = false;
        if (condition) {
            // 忘记 throw 一个异常
            new RuntimeException("Dissatisfied condition");
        }
    }

    private static final String lockField = "LOCK_PLACE_HOLDER";

    private static void deadLock() {
        synchronized (lockField) {
            System.out.println("死锁问题");
        }
    }

    private static void nullIssue() {
        String test = null;

        if (test != null || test.length() > 0) {
            System.out.println("空指针异常");
        }

        if (test == null && test.length() > 0) {
            System.out.println("相反的情况，导致空指针异常");
        }
    }

    private static void infiniteRecursive() {
        Person testPerson = new Person("test");
        testPerson.name();
    }


    private static void mathCalculate() {
        double number1 = 0.1;
        double number2 = 0.2;
        double number3 = 0.3;

        if (number1 + number2 == number3) {
            System.out.println("精度问题示例");
        }
    }
}
