package cn.printf.concurrence;

public class SynchronizationCount {
    static Integer count = 5;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(SynchronizationCount::count);
        Thread t2 = new Thread(SynchronizationCount::count);
        t1.start();
        t2.start();

        Thread.sleep(500);
        System.out.println(count);
    }

    private static void count() {
        SynchronizationCount.count = SynchronizationCount.count + 1;
    }
}
