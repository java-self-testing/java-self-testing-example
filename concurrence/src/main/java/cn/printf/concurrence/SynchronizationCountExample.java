package cn.printf.concurrence;

public class SynchronizationCountExample {
    static Integer count = 5;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(SynchronizationCountExample::count);
        Thread t2 = new Thread(SynchronizationCountExample::count);
        t1.start();
        t2.start();

        Thread.sleep(500);
        System.out.println(count);
    }

    private static void count() {
        SynchronizationCountExample.count = SynchronizationCountExample.count + 1;
    }
}
