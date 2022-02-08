package cn.prinf.demos.junit.basic;

public class ExceptionPractise {
    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new DivideByZeroException("divisor is zero");
        }
        int result = 0;
        float remainder = dividend;
        while (remainder >= divisor) {
            result++;
            remainder = remainder - divisor;
        }
        return result;
    }
}
