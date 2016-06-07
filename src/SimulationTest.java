import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zohrath on 2015-11-30.
 */
public class SimulationTest {
    Simulation s = new Simulation();
    @Test
    public void testStep() throws Exception {
        try {
            for (int i = 0; i < 100; i++ ) {
                s.step();
            }
        }
        catch (Exception e) {
            assert (false);
        }
    }
}