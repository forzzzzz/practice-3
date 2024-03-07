package org.example;

public class DirectCurrent {
    private final Item2d result;

    public DirectCurrent() {
        result = new Item2d();
    }

    public Item2d calculateDirectCurrent(double v, double r1, double r2, double r3, double r4) {
        double i1 = v / r1;
        double i2 = v / r2;
        double i3 = v / r3;
        double i4 = v / r4;

        double totalCurrent = i1 + i2 + i3 + i4;

        long bits = Double.doubleToLongBits(totalCurrent);
        String binaryCurrent = Long.toBinaryString(bits);

        result.setValues(binaryCurrent, v, r1, r2, r3, r4);

        return result;
    }

    public SomeNewClass createSomeNewClass(String data) {
        return new SomeNewClass(data);
    }
}
