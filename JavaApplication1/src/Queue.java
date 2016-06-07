
/**
 * Created by zohrath on 2015-11-15.
 */
public class Queue {
    private Node first;
    private Node last;
    public int length;

    private class Node {
        final Customer element;
        Node next;

        private Node(Customer _element) {
            element = _element;
            next = null;
        }

        private Node() {
            element = new Customer();
            next = null;
        }

        public String toString() {
            return this.element.toString();
        }
    }

    public Queue( Node _first) {
        first = _first;
        last = _first;
        length = 1;
    }

    public Queue() {
        first = null;
        last = null;
        length = 0;
    }

    public int length() {
        return this.length;
    }

    public void enqueue(Customer c) {
        if ( this.first != null ) {
            this.last.next = new Node(c);
            this.last = this.last.next;
            this.length++;
        }
        else {
            this.first = new Node(c);
            this.last = this.first;
            this.length++;
        }

    }

    public void enqueue() {
        if ( this.first != null ) {
            this.last.next = new Node();
            this.last = this.last.next;
            this.length++;
        }
        else {
            this.first = new Node();
            this.last = this.first;
            this.length++;
        }

    }


    public Customer dequeue() throws EmptyQueueException {
        if ( this.first != null ) {
            Customer temp = this.first.element;
            this.first = this.first.next;
            this.length--;
            return temp;
        }
        else {
            throw new EmptyQueueException();
        }

    }

    public Customer first() throws Exception {
        if (this.first == null) {
            throw new Exception();
        }
        return this.first.element;
    }


    public void stepQueue() {
        try {
            this.first().serve();
        } catch (Exception ignored) {

        }
    }

    public boolean lookupCustomerIsDone() {
        try {
            return this.first().lookupGroceries();
        } catch (Exception ignored) {

        }
        return false;
    }

    private int bornTime(Node n) {
        try {
            return n.element.bornTime();
        } catch (Exception ignore) {
            return 0;
        }

    }

    public int getNumberOfCustomers() {
        int ack = 0;
        if ( this.first != null) {
            return getNumberOfCustomersAux(this.first, ack);
        }
        else return 0;
    }

    private int getNumberOfCustomersAux(Node n, int ack) {
        ack++;
        if (n.next != null) {
            return getNumberOfCustomersAux(n.next, ack);
        }
        return ack;
    }

    public int getTotalWaitTime(int time) {
        int ack = 0;
        if ( this.first != null ) {
            return getTotalWaitTimeAux(this.first, time, ack);
        }
        else return 0;
    }

    private int getTotalWaitTimeAux(Node n, int time, int ack) {
        ack += (time - this.bornTime(n));
        if (n.next != null) {
            return getTotalWaitTimeAux(n.next, time, ack);
        }
        return ack;
    }
    public String toString() {
        String temp = "";
        Node current = this.first;

        while ( current != null ) {
            temp += current.toString();
            current = current.next;
        }
        return temp;
    }
}
