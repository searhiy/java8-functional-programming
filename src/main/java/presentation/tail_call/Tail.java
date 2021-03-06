package presentation.tail_call;

import java.math.BigInteger;
import java.util.stream.Stream;

/**
 * Created by Serhii K. on 3/11/2016.
 */
@FunctionalInterface
public interface Tail<T> {

    Tail<T> apply();

    default boolean isDone() {
        return false;
    }

    default T result() {
        throw new UnsupportedOperationException("Not done yet.");
    }

    default T invoke() {
        return Stream.iterate(this, Tail::apply)
                .filter(Tail::isDone)
                .findFirst()
                .get()
                .result();
    }

    static <T> Tail<T> done(final T value) {
        return new Tail<T>() {
            @Override
            public T result() {
                return value;
            }

            @Override
            public boolean isDone() {
                return true;
            }

            @Override
            public Tail<T> apply() {
                throw new UnsupportedOperationException("Not supported.");
            }
        };
    }

}
