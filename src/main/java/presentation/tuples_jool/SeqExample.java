package presentation.tuples_jool;

import org.jooq.lambda.Seq;

import static org.jooq.lambda.tuple.Tuple.tuple;

/**
 * Created by Serhii K. on 3/11/2016.
 */
public class SeqExample {

    public static void main(String[] args) {
        // (1, 2, 3, 4, 5, 6)
        Seq.of(1, 2, 3).concat(Seq.of(4, 5, 6));

        // true
        Seq.of(1, 2, 3, 4).contains(2);

        // true
        Seq.of(1, 2, 3, 4).containsAll(2, 3);

        // true
        Seq.of(1, 2, 3, 4).containsAny(2, 5);

        // (tuple(1, "A"), tuple(1, "B"), tuple(2, "A"), tuple(2, "B"))
        Seq.of(1, 2).crossJoin(Seq.of("A", "B"));

        // (1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, ...)
        Seq.of(1, 2, 3).cycle();

        // tuple((1, 2, 3), (1, 2, 3))
        Seq.of(1, 2, 3).duplicate();

        // "abc"
        Seq.of("a", "b", "c").foldLeft("", (u, t) -> t + u);

        // "cba"
        Seq.of("a", "b", "c").foldRight("", (t, u) -> t + u);

        // { 1 = (1, 3), 0 = (2, 4) }
        Seq.of(1, 2, 3, 4).groupBy(i -> i % 2);

        // (tuple(1, (1, 3)), tuple(0, (2, 4)))
        Seq.of(1, 2, 3, 4).grouped(i -> i % 2);

        // (tuple(1, 1), tuple(2, 2))
        Seq.of(1, 2, 4).innerJoin(Seq.of(1, 2, 3), (a, b) -> a == b);

        // (1, 0, 2, 0, 3, 0, 4)
        Seq.of(1, 2, 3, 4).intersperse(0);

        // "123"
        System.out.println(Seq.of(1, 2, 3).toString());

        // "1, 2, 3"
        System.out.println(Seq.of(1, 2, 3).toString(", "));

        // "^1|2|3$"
        System.out.println(Seq.of(1, 2, 3).toString("|", "^", "$"));

        // (tuple(1, 1), tuple(2, 2), tuple(4, null))
        Seq.of(1, 2, 4).leftOuterJoin(Seq.of(1, 2, 3), (a, b) -> a == b);

        // (1, 2)
        Seq.of(1, 2, 3, 4, 5).limitWhile(i -> i < 3);

        // (1, 2)
        Seq.of(1, 2, 3, 4, 5).limitUntil(i -> i == 3);

        // (1, 2L)
        Seq.of(new Object(), 1, "B", 2L).ofType(Number.class);

        // (tuple(1, 1), tuple(2, 2), tuple(null, 3))
        Seq.of(1, 2, 4).rightOuterJoin(Seq.of(1, 2, 3), (a, b) -> a == b);

        // tuple((1, 3), (2, 4))
        Seq.of(1, 2, 3, 4).partition(i -> i % 2 != 0);

        // (1, 3, 4)
        Seq.of(1, 2, 3, 4).remove(2);

        // (1, 4)
        Seq.of(1, 2, 3, 4).removeAll(2, 3, 5);

        // (2, 3)
        Seq.of(1, 2, 3, 4).retainAll(2, 3, 5);

        // (4, 3, 2, 1)
        Seq.of(1, 2, 3, 4).reverse();

        // (3, 1, 4, 5, 2) for example
        Seq.of(1, 2, 3, 4, 5).shuffle();

        // (3, 4, 5)
        Seq.of(1, 2, 3, 4, 5).skipWhile(i -> i < 3);

        // (3, 4, 5)
        Seq.of(1, 2, 3, 4, 5).skipUntil(i -> i == 3);

        // (2, 3)
        Seq.of(1, 2, 3, 4, 5).slice(1, 3);

        // tuple((1, 2), (3, 4, 5))
        Seq.of(1, 2, 3, 4, 5).splitAt(2);

        // tuple(1, (2, 3, 4, 5))
        Seq.of(1, 2, 3, 4, 5).splitAtHead();

        // tuple((1, 2, 3), (a, b, c))
        Seq.unzip(Seq.of(tuple(1, "a"), tuple(2, "b"), tuple(3, "c")));

        // (tuple(1, "a"), tuple(2, "b"), tuple(3, "c"))
        Seq.of(1, 2, 3).zip(Seq.of("a", "b", "c"));

        // ("1:a", "2:b", "3:c")
        Seq.of(1, 2, 3).zip(Seq.of("a", "b", "c"), (x, y) -> x + ":" + y);

        // (tuple("a", 0), tuple("b", 1), tuple("c", 2))
        Seq.of("a", "b", "c").zipWithIndex();
    }
}
