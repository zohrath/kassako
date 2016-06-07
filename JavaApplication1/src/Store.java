
/**
 * Created by zohrath on 2015-11-15.
 */

import java.util.ArrayList;

class Store {
    private final int registerQuantity;
    final Register[] registers;


    public Store() {
        registerQuantity = 4;
        registers = new Register[registerQuantity];
        for (int i = 0; i < registerQuantity; i++) {
            this.registers[i] = new Register();
        }
    }

    public Store(int _registerQuantity) {
        registerQuantity = _registerQuantity;
        registers = new Register[registerQuantity];
        for (int i = 0; i < registerQuantity; i++) {
            this.registers[i] = new Register();
        }
    }

    //Ställ kunden c i den kortaste kön.
    public void newCustomer(Customer c) {
        // Sätt minsta kölängden till [0] för att ha något att jämföra med
        int queueLength = this.registers[0].getQueueLength();
        int registerIndex = 0;
        int smallestQueue = this.registers[0].getQueueLength();

        // Hittar kassa med minst kö
        for ( int j = 0; j < registerQuantity; j++ ) {
            if ( smallestQueue > this.registers[j].getQueueLength()) {
                registerIndex = j;
            }
        }
        if (this.registers[0].isopen()) {
            if ( queueLength > 3 ) {
                if ( !this.registers[registerIndex].isopen() ) {
                    this.registers[registerIndex].open();
                }
                this.registers[registerIndex].addToQueue(c);
            }
            else this.registers[0].addToQueue(c);
        } else {
            this.registers[0].open();
            this.registers[0].addToQueue(c);
        }
    }




    public void step() {
        for ( int k = 0; k < registerQuantity; k++ ) {
            this.registers[k].step();
        }
    }

    public ArrayList<Customer> getDoneCustomers(ArrayList<Customer> doneCustomers) {
        for ( Register r : registers ) {
            if ( r.currentCustomerIsDone() ) {
                try {
                    doneCustomers.add(r.removeCurrentCustomer());
                } catch (Exception ignored) {
                }
            }
        }
        return doneCustomers;
    }

    public int getNumberOfRegisters() {
        int registerAck = 0;
        for ( Register r: registers ) {
            registerAck++;
        }
        return registerAck;
    }

    public int getTotalCustomers() {
        int total = 0;
        for ( Register r : registers ) {
            total += r.q.getNumberOfCustomers();
        }
        return total;
    }

    public int getTotalWaitTime(int time) {
        int total = 0;
        for ( Register r : registers ) {
            total += r.q.getTotalWaitTime(time);
        }
        return total;
    }


    public String toString() {
        String temp = "";
        for ( Register r : registers ) {
            temp += r.toString() + "\n";
        }
        return temp;
    }
}