package cn.prinf.demos.junit.basic;

public class AssertPractise {

    /**
     * example for assert keyword
     *
     * @param first
     * @param second
     * @return
     */
    public static String contactString(String first, String second) {
        assert first != null;
        assert second != null;
        return first + second;
    }


    public static String helloAndNow() {
        return "Hello, world!" + System.currentTimeMillis();
    }

    public static float calculateAA(float totalPrice, float counts) {
        return totalPrice / counts;
    }
}
