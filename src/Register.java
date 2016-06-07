

/**
 * Created by zohrath on 2015-11-15.
 */
public class Register {

    private boolean open;
    final Queue q;


    public Register(boolean _open) {
        open = _open;
        q = new Queue();
    }

    public Register() {
        open = false;
        q = new Queue();
    }

    public void open() {
        this.open = true;
    }

    public boolean isopen() {
        return this.open;
    }

    public void step() {
        q.stepQueue();
    }

    public boolean hasCustomers() {
        return q.length != 0;
    }

    public boolean currentCustomerIsDone() {
        return q.lookupCustomerIsDone();
    }

    public void addToQueue(Customer c) {
        q.enqueue(c);
    }

    public Customer removeCurrentCustomer() throws Exception {
        return q.dequeue();
    }

    public int getQueueLength() {
        return q.length();
    }

    public String toString() {
        if ( !this.isopen() ) {
            return "X  [ ]";
        }
        Customer temp;
        try {

            temp = q.first();
            if ( temp.getGroceries() != 0 ) {
                return "[" + temp.getGroceries() + "]" + q.toString();
            }
            return "[ ]" + q.toString();
        }
        catch (Exception e) {
            return "[ ]";
        }
    }
}
