package presentation.tail_call;

import java.math.BigInteger;

/**
 * Created by Serhii K. on 3/11/2016.
 */
public class TestClass {

    public static BigInteger factorial(int n) {
        return streamFactorial(BigInteger.ONE, n).invoke();
    }

    private static Tail<BigInteger> streamFactorial(BigInteger x, int n) {
        return () -> {
            switch (n) {
                case 1:
                    return Tail.done(x);
                default:
                    return streamFactorial(x.multiply(BigInteger.valueOf(n)), n - 1);
            }
        };
    }

    public static void main(String[] args) {
        System.out.println(factorial(11_310));
        System.out.println(factorial(110_310));
        //System.out.println(factorial(1_110_310));
        /*Tail<BigInteger> bi = streamFactorial(new BigInteger("10000000"), 43555555); // doesn't have java.lang.StackOverflowError
        System.out.println(bi.invoke());*/
    }
}
