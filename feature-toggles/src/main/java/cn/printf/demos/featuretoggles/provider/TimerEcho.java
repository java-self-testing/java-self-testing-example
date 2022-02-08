package cn.printf.demos.featuretoggles.provider;

public class TimerEcho implements Echo {
    public TimerEcho() {
    }

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
