package cn.printf.demos.featuretoggles;

public class InterfaceVersion {
    static boolean timerEnabled = false;

    public static void main(String[] args) throws InterruptedException {
        if (timerEnabled) {
            new TimerEcho().echoHello();
        } else {
            new BasicEcho().echoHello();
        }
    }

    interface Echo {
        void echoHello();
    }

    static class BasicEcho implements Echo {
        public void echoHello() {
            System.out.println("Hello world!");
        }
    }

    static class TimerEcho implements Echo {
        public void echoHello() {
            while (true) {
                System.out.println("Hello world!");
                try {
                    Thread.sleep(1000);
                } catch (Exception ignored) {

                }
            }
        }
    }
}
