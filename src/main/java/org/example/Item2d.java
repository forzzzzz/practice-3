package org.example;

import java.io.Serial;
import java.io.Serializable;

public class Item2d implements Serializable {
    private String binaryCurrent;
    private double v;
    private double r;
    @Serial
    private static final long serialVersionUID = 1L;

    public Item2d() {
        binaryCurrent = "0";
        v = 0;
        r = 0;
    }

    public Item2d(String binaryCurrent, double v, double r) {
        this.v = v;
        this.r = r;
        this.binaryCurrent = binaryCurrent;
    }

    public void setValues(String binaryCurrent, double v, double r) {
        this.v = v;
        this.r = r;
        this.binaryCurrent = binaryCurrent;
    }

    public String getBinaryCurrent() {
        return binaryCurrent;
    }
    public double getV() {
        return v;
    }
    public double getR() {
        return r;
    }

    @Override
    public String toString() {
        return "\nBinaryCurrent = " + binaryCurrent + "\nV = " + v + "\nR = " + r;
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
}
