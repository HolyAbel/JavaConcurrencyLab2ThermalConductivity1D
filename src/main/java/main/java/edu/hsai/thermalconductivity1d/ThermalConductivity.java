package main.java.edu.hsai.thermalconductivity1d;

import java.text.DecimalFormat;

public class ThermalConductivity {

    public static double[] getDistribution(int steps, int fieldLenght, double startTemp, double speedCoef, int treadsNum) {
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        double[] temperature = new double[fieldLenght];

        temperature[fieldLenght / 2 - 1] = startTemp;
        for (int j = 0; j < fieldLenght; j++) {
            System.out.printf("%6s ", decimalFormat.format(temperature[j]));
        }
        System.out.println();

        Thread[] threads = new Thread[treadsNum];
        int chunkSize = fieldLenght / treadsNum;

        for (int t = 0; t < steps; t++) {
            for (int i = 0; i < treadsNum; i++) {
                final int startInd = i * chunkSize;
                final int endInd = (i + 1) * chunkSize;

                threads[i] = new Thread(() -> {
                    for (int pos = startInd; pos < endInd; pos++) {
                        if (pos != 0  && pos != (fieldLenght - 1)) {
                            temperature[pos] = temperature[pos] + speedCoef * (temperature[pos + 1] + temperature[pos - 1] - 2 * temperature[pos]);
                        }
                        else if (pos == 0) {
                            temperature[pos] = temperature[pos] + speedCoef * (temperature[pos + 1] - temperature[pos]);
                        }
                        else {
                            temperature[pos] = temperature[pos] + speedCoef * (temperature[pos - 1] - temperature[pos]);
                        }
                    }
                });
            }

            for (Thread thread : threads) {
                thread.start();
            }

            try {
                for (Thread thread : threads) {
                    thread.join();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int j = 0; j < fieldLenght; j++) {
                System.out.printf("%6s ", decimalFormat.format(temperature[j]));
            }
            System.out.println();
        }

        return temperature;
    }
}
