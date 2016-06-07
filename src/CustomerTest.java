import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by zohrath on 2015-11-30.
 */
public class CustomerTest {
    int g = 4;
    int b = -1;
    Customer c;




    @Test
    public void testIsDone() throws Exception {
        c = new Customer(b, g);
        if (c.isDone()) throw new AssertionError();
        c.serve();
        c.serve();
        c.serve();
        c.serve();
        if (!c.isDone()) throw new AssertionError();

    }

    @Test
    public void testGetGroceries() throws Exception {
        c = new Customer(b, g);
        if (c.getGroceries() != g) throw new AssertionError();
        c.serve();
        g -= 1;
        c.serve();
        g -= 1;
        if (c.getGroceries() != g) throw new AssertionError();
    }
}