import java.io.Reader;

import static java.lang.Integer.*;

/**
 * Created by zohrath on 2015-11-15.
 */
class Simulator{

    public static void main(String[] args) throws InterruptedException{
        int steps = 100000;
        Simulation s = new Simulation(
                parseInt(args[0]),
                parseInt(args[1]),
                parseInt(args[2]),
                parseInt(args[3]),
                parseInt(args[4]));
        for(int i = 0; i < steps; i++){
            //System.out.print("\033[2J\033[;H");
            s.step();
          //  System.out.println(s);
            //Thread.sleep(500);
        }
       // System.out.println("");
       // System.out.println("Simulation finished!");
    }
}