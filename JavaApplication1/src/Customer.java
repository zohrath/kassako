import java.io.IOException;

/**
 * Created by zohrath on 2015-11-15.
 */
public class Customer {
    private final int bornTime;
    public int groceries;

    public Customer(int _bornTime, int _groceries) throws IOException {
        assert !(_bornTime < 0); // Defensiv assert
        bornTime = _bornTime;
        if (_groceries < 0) throw new IOException();
        groceries = _groceries;
    }

    public Customer() {
        bornTime = 0;
        groceries = 4;
    }

    public String toString() {
        return "@";
    }

    public void serve() {
        this.groceries--;
    }

    public boolean isDone() {
        return groceries == 0;
    }

    public boolean lookupGroceries() {
        return this.groceries == 0;
    }

    public int bornTime() {
        return this.bornTime;
    }

    public int getGroceries() {
        return this.groceries;
    }
}
