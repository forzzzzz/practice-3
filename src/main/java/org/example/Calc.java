package org.example;


import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Calc {
    private static final String FNAME = "Item2d.bin";
    private Item2d result;
    private final DirectCurrent directCurrent;
    public Calc() {
        result = new Item2d();
        directCurrent = new DirectCurrent();
    }
    public void setResult(Item2d result) {
        this.result = result;
    }
    public Item2d getResult() {
        return result;
    }
    private String calc(double v, double r1, double r2, double r3, double r4) {
        result = directCurrent.calculateDirectCurrent(v, r1, r2, r3, r4);
        return result.getBinaryCurrent();
    }

    public String init(double v, double r1, double r2, double r3, double r4) {
        return result.setBinaryCurrent(calc(v, r1, r2, r3, r4));
    }
    public void show() {
        System.out.println(result);
    }
    public void save() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
        os.writeObject(result);
        os.flush();
        os.close();
    }

    public void restore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
        result = (Item2d)is.readObject();
        is.close();
    }

    public Displayable createDisplayable() {
        return () -> System.out.println(result);
    }
}