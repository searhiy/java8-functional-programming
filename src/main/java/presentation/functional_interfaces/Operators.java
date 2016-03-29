package presentation.functional_interfaces;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.UnaryOperator;

/**
 * Created by inet on 3/29/2016.
 */
public class Operators {

    public static void main(String[] args) {
        // unary operator
        UnaryOperator<String> u1 = String::toUpperCase;
        UnaryOperator<String> u2 = x -> x.toUpperCase();
        System.out.println(u1.apply("chirp"));
        System.out.println(u2.apply("chirp"));

        // binary operator
        BinaryOperator<String> b1 = String::concat;
        BinaryOperator<String> b2 = (string, toAdd) -> string.concat(toAdd);
        System.out.println(b1.apply("baby ", "chick")); // baby chick
        System.out.println(b2.apply("baby ", "chick")); // baby chick

        BinaryOperator<Integer> bi1 = BinaryOperator.minBy(Comparator.reverseOrder());
        System.out.println(bi1.apply(2, 3)); // 3

        IntBinaryOperator io1 = (x, y) -> x > y ? x : y;
        System.out.println(io1.applyAsInt(2, 3)); // 3

        BinaryOperator<Integer> bi2 = BinaryOperator.maxBy(Comparator.reverseOrder());
        System.out.println(bi2.apply(2, 3));  // 2

        IntBinaryOperator io2 = (x, y) -> x < y ? x : y;
        System.out.println(io2.applyAsInt(2, 3));
    }
}
