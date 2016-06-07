import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zohrath on 2015-11-30.
 */
public class RegisterTest {
    Register r = new Register();
    Customer c = new Customer();
    @Test
    public void testIsopen() throws Exception {
        assert (!r.isopen());
        r.open();
        assert (r.isopen());
    }

    @Test
    public void testHasCustomers() throws Exception {
        assert (!r.hasCustomers());
        r.addToQueue(c);
        assert (r.hasCustomers());
    }
}