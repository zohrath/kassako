import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zohrath on 2015-11-30.
 */
public class StoreTest {
    Store s = new Store();
    Customer c = new Customer();

    @Test
    public void testGetNumberOfRegisters() throws Exception {
        assert ( s.getNumberOfRegisters() == 4);
    }

    @Test
    public void testGetTotalWaitTime() throws Exception {
        s.newCustomer(c);
        s.step();
        assert ( s.getTotalWaitTime(1) == 1 );
    }
}