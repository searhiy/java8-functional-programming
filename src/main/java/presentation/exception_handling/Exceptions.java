package presentation.exception_handling;

import com.google.common.base.Throwables;
import org.jooq.lambda.Unchecked;
import org.jooq.lambda.fi.util.function.CheckedFunction;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.function.Function;

/**
 * Created by Serhii K. on 3/1/2016.
 */
public class Exceptions {

    public static void main(String[] args) {
        //

        // jooq library
        Unchecked.function(className -> Class.forName("name"));
    }


    public static <T, R> Function<T, R> function(CheckedFunction<T, R> function) {
        return (t) -> {
            try {
                return function.apply(t);
            } catch (IOException ex) {
                throw new UncheckedIOException(ex);
            } catch (Throwable ex) {
                throw Throwables.propagate(ex);
            }
        };
    }
}
