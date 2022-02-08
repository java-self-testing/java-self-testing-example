package cn.printf.demos.featuretoggles;

public class BasicVersion {
    static boolean timerEnabled = true;

    public static void main(String[] args) throws InterruptedException {
        echoHello();
    }

    public static void echoHello() throws InterruptedException {
        if (timerEnabled) {
            while (true) {
                System.out.println("Hello world!");
                Thread.sleep(1000);
            }
        } else {
            System.out.println("Hello world!");
        }
    }
}
