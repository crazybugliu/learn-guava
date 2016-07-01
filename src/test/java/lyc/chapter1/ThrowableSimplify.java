package lyc.chapter1;

import com.google.common.base.Throwables;
import org.junit.Test;

import java.io.IOException;

public class ThrowableSimplify {

    @Test
    public void doThrow() throws IOException {
        try {
//            throw new NullPointerException("you take it");
            throw new IOException("I don't know what.");
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (Throwable t) {
            /**如果是IOException，则抛出*/
            Throwables.propagateIfInstanceOf(t, IOException.class);
            /**如果 Throwable 是 Error 或 RuntimeException，直接抛出；
             * 否则把 Throwable 包装成 RuntimeException 抛出。*/
            throw Throwables.propagate(t);
        }
    }
}
