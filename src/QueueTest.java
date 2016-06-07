import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zohrath on 2015-11-30.
 */
public class QueueTest {
    Queue q = new Queue();
    Customer c = new Customer();
    @Test
    public void testLength() throws Exception {
        q.enqueue(c);
        q.enqueue(c);
        q.enqueue(c);
        assert (q.length() == 3);
    }

    @Test
    public void testGetNumberOfCustomers() throws Exception {
        q.enqueue(c);
        q.enqueue(c);
        q.enqueue(c);
        q.enqueue(c);
        q.enqueue(c);
        assert (q.getNumberOfCustomers() == 5);
    }
}