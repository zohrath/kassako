import java.io.IOException;

/**
 * Created by zohrath on 2015-12-03.
 */
public class CustomerRetiree extends Customer { // Arv
    int stepper;
    public CustomerRetiree(int _bornTime, int _groceries) throws IOException {
        super(_bornTime, _groceries);   // Gör samma sak som customer med b och g
        }

    @Override
    public void serve() { // Metodspecialisering
        if ( stepper == 1 ) {
            this.groceries--;
            this.stepper--;
        }
        else this.stepper++;
    }

}