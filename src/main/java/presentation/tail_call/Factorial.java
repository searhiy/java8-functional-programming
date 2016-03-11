package presentation.tail_call;

import java.math.BigInteger;

/**
 * Created by Serhii K. on 3/11/2016.
 */
class Calculation
{
    BigInteger fact(int n)
    {
        BigInteger result;

        if(n==1)
            return new BigInteger("1");

        result = fact(n - 1).multiply(BigInteger.valueOf(n));
        return result;
    }
}

public class Factorial
{
    public static void main(String args[])
    {
        Calculation obj_one = new Calculation();

        BigInteger a = obj_one.fact(11_310); // java.lang.StackOverflowError n=11_310
        System.out.println("The factorial of the number is : " + a);
    }
}
