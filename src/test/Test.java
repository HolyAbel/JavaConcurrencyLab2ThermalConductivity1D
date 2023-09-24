import org.junit.Test;

import static main.java.edu.hsai.thermalconductivity1d.ThermalConductivity.getDistribution;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class Test {
    @Test
    public void tests() {
        double delta = 0.1;

        double[] firstExpected = { 0, 0.1, 1.4, 6.9, 1.4, 0.1, 0, 0 };
        assertTrue(compareArrays(firstExpected,
                getDistribution(10, 8, 10.0, 0.02, 4), delta));


        double[] secondExpected = { 0.2, 1.4, 7.5, 18.8, 7, 1.5, 0.2, 0 };
        assertTrue(compareArrays(secondExpected,
                getDistribution(10, 8, 36.6, 0.04, 4), delta));
    }

    private boolean compareArrays(double[] expected, double[] actual, double delta) {

        for (int i = 0; i < expected.length; i++) {
            fif (Math.abs(expected[i] - actual[i]) > delta) {
                return false;
            }
        }

        return true;
    }
}
