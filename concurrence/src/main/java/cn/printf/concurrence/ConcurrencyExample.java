package cn.printf.concurrence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcurrencyExample {
    static final List a = Collections.synchronizedList(new ArrayList());

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> addIfAbsent(17));
        t.start();
        addIfAbsent(17);
        t.join();
        System.out.println(a);
    }

    private static void addIfAbsent(int x) {
        if (!a.contains(x)) {
            a.add(x);
        }
    }
}
