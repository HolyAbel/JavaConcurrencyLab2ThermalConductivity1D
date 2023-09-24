package main.java.edu.hsai.thermalconductivity1d;

import static main.java.edu.hsai.thermalconductivity1d.ThermalConductivity.getDistribution;

public class App {
    public static void main(String[] args) {
//        int steps = 100;
//        int fieldLenght = 100000;
//        double startTemp = 94.1;
//        double speedCoef = 0.02;
//        int treadsNum = 128;
//        getDistribution(steps, fieldLenght, startTemp, speedCoef, treadsNum);
        getDistribution(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Double.parseDouble(args[2]),
                Double.parseDouble(args[3]), Integer.parseInt(args[4]));
    }
}
