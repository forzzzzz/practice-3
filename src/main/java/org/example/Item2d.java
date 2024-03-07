package org.example;

import java.io.Serial;
import java.io.Serializable;

public class Item2d implements Serializable, Displayable {
    private String binaryCurrent;
    private double v;
    private double r1;
    private  double r2;
    private  double r3;
    private  double r4;
    @Serial
    private static final long serialVersionUID = 1L;

    public Item2d() {
        binaryCurrent = "0";
        v = 0;
        r1 = 0;
        r2 = 0;
        r3 = 0;
        r4 = 0;
    }

    public Item2d(String binaryCurrent, double v, double r1, double r2, double r3, double r4) {
        this.v = v;
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = r3;
        this.r4 = r4;
        this.binaryCurrent = binaryCurrent;
    }

    public void setValues(String binaryCurrent, double v, double r1, double r2, double r3, double r4) {
        this.v = v;
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = r3;
        this.r4 = r4;
        this.binaryCurrent = binaryCurrent;
    }

    public String getBinaryCurrent() {
        return binaryCurrent;
    }
    public double getV() {
        return v;
    }
    public double getR1() {
        return r1;
    }
    public double getR2() {
        return r2;
    }
    public double getR3() {
        return r3;
    }
    public double getR4() {
        return r4;
    }

    @Override
    public String toString() {
        return "BinaryCurrent = " + binaryCurrent + "\nV = " + v + "\nR1 = " + r1 + "\nR2 = " + r2 + "\nR3 = " + r3 + "\nR4 = " + r4;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Item2d other = (Item2d) obj;
        if (binaryCurrent == null) {
            return other.binaryCurrent == null;
        } else return binaryCurrent.equals(other.binaryCurrent);
    }

    public void display() {
        System.out.println(this);
    }

    @Override
    public void display(String format) {
        switch (format){
            case "String":
                display();
                break;
            case "Table":

                System.out.println("BinaryCurrent: " + getBinaryCurrent());
                System.out.println("+----------------+------------+------------+------------+------------+");
                System.out.println("|        V       |     R1     |     R2     |     R3     |     R4     |");
                System.out.println("+----------------+------------+------------+------------+------------+");
                System.out.printf("|%14.1f  |%10.1f  |%10.1f  |%10.1f  |%10.1f  |\n",
                        getV(), getR1(),
                        getR2(), getR3(), getR4());
                System.out.println("+----------------+------------+------------+------------+------------+");
                break;
            default:
                System.out.println("Invalid format!");
        }
    }
}
