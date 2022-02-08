package cn.printf.concurrence;

public class DeadLockExample {
    public static void startBusiness() {
        DeadLockSimulator deadLockSimulator = new DeadLockSimulator();
        Thread thread1 = new Thread(deadLockSimulator, "thread-1");
        Thread thread2 = new Thread(deadLockSimulator, "thread-2");
        thread1.start();
        thread2.start();
    }

    private static class DeadLockSimulator implements Runnable {
        private Object object1 = new Object();
        private Object object2 = new Object();

        public void methodA() {
            synchronized (object1) {
                synchronized (object2) {
                    System.out.println("MethodA executed");
                }
            }
        }

        public void methodB() {
            synchronized (object2) {
                synchronized (object1) {
                    System.out.println("MethodB executed");
                }
            }
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                methodA();
                methodB();
            }
        }
    }
}
