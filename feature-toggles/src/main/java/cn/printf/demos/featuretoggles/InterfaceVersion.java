package cn.printf.demos.featuretoggles;

public class InterfaceVersion {
    static boolean timerEnabled = false;

    public static void main(String[] args) throws InterruptedException {
        if (timerEnabled) {
            new BasicEcho().echoHello();
        } else {
            new TimerEcho().echoHello();
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
