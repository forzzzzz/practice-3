package org.example;

public class DirectCurrent {
    public static String calculateDirectCurrent(double v, double r) {
        double i = v / r;
        long bits = Double.doubleToLongBits(i);
        return Long.toBinaryString(bits);
    }
}
