/**
 * Created by zohrath on 2015-11-15.
 */
import java.io.IOException;
import java.util.ArrayList;

public class Simulation {
    private final Store store;
    private ArrayList<Customer> served;
    private int max = 0;
    private double avg = 0;
    private int time;
    private int intensity;
    private int numberOfRegisters;
    private int maxGroceries;
    private int thresholdForNewRegister;
    private ArrayList<Customer> doneCustomers = new ArrayList<>();



    public Simulation() {
        store = new Store();
        time = 0;
        intensity = 50;
        maxGroceries = 7;
        thresholdForNewRegister = 4;
    }

    public Simulation(int _time, int _intensity, int _maxGroceries, int _thresholdForNewRegister, int _registers) {
        time = _time;
        intensity = _intensity;
        numberOfRegisters = _registers;
        store = new Store(_registers);
        maxGroceries = _maxGroceries;
        thresholdForNewRegister = _thresholdForNewRegister;
    }

    public void step() {
        this.createNewCustomer();
        max = 0;
        max = getMaxCustomerWaitTime();
        avg = 0;
        avg = getAvgCustomerWaitTime();
        this.store.step();
        served = this.store.getDoneCustomers(doneCustomers);
        time++;
    }

    private void createNewCustomer() {
        int temp = (int) ((Math.random()*100) + 1);
        if ( temp < intensity ) {
            int groceries = (int) (Math.random() * (maxGroceries - 1)) + 1;
            int customerType = (int) ((Math.random()*100) + 1);
            if ( customerType > 80 ) {
                CustomerRetiree c = null;
                try {
                    c = new CustomerRetiree(time, groceries); // CHECKED
                } catch (IOException e) {
                    e.printStackTrace();
                }
                this.store.newCustomer(c);
            }
            else {
                Customer c = null;
                try {
                    c = new Customer(time, groceries);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                this.store.newCustomer(c);
            }

        }
    }

    private double getAvgCustomerWaitTime() {
        double totalWait;
        double totalNumber;
        totalWait = this.store.getTotalWaitTime(time);
        totalNumber = this.store.getTotalCustomers();
        if ( totalWait == 0 ) {
            return 0;
        }
        else return (totalWait / totalNumber);
    }

    private int getMaxCustomerWaitTime() {
        int ack = time;
        for ( int i = 0; i < numberOfRegisters; i++) {
            try {
                if ( this.store.registers[i].q.first().bornTime() < ack) {
                        ack = this.store.registers[i].q.first().bornTime();
                }
            } catch (Exception ignored) {

            }
        }
        return time - ack;
    }


    private int getCustomersServed(ArrayList<Customer> served) {
        return served.size();
    }

    public String toString() {
        return "Simulation\n\n" + this.store.toString() +
                "\n\n Customers served: " + getCustomersServed(served) +
                "\n\n Max waiting time: " + max +
                "\n\n Average waiting time: " + avg;
    }
}