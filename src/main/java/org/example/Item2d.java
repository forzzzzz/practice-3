package org.example;

import java.io.Serial;
import java.io.Serializable;

public class Item2d implements Serializable {
    private String binaryCurrent;
    @Serial
    private static final long serialVersionUID = 1L;

    public Item2d() {
        binaryCurrent = "0";
    }

    public Item2d(String binaryCurrent) {
        this.binaryCurrent = binaryCurrent;
    }

    public String setBinaryCurrent(String binaryCurrent) {
        return this.binaryCurrent = binaryCurrent;
    }

    public String getBinaryCurrent() {
        return binaryCurrent;
    }

    @Override
    public String toString() {
        return "BinaryCurrent = " + binaryCurrent;
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
            if (other.binaryCurrent != null)
                return false;
        } else if (!binaryCurrent.equals(other.binaryCurrent))
            return false;
        return true;
    }
}
