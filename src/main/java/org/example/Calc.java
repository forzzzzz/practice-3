package org.example;


import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Calc {
    private static final String FNAME = "Item2d.bin";
    private static Item2d result = new Item2d();
    private static final DirectCurrent directCurrent = new DirectCurrent();

    private Calc() {

    }

    public static void setResult(Item2d result) {
        Calc.result = result;
    }

    public static Item2d getResult() {
        return result;
    }

    private static String calc(double v, double r1, double r2, double r3, double r4) {
        result = directCurrent.calculateDirectCurrent(v, r1, r2, r3, r4);
        return result.getBinaryCurrent();
    }

    public static String init(double v, double r1, double r2, double r3, double r4) {
        result = directCurrent.calculateDirectCurrent(v, r1, r2, r3, r4);
        return result.getBinaryCurrent();
    }

    public static void show() {
        System.out.println(result);
    }

    //Макрокоманда
    public static void initAndShowResult(double v, double r1, double r2, double r3, double r4){
        init(v, r1, r2, r3, r4);
        show();
    }

    public static void save() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
        os.writeObject(result);
        os.flush();
        os.close();
    }

    public static void restore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
        result = (Item2d) is.readObject();
        is.close();
    }

    public static Displayable createDisplayable() {
        return new Displayable() {
            @Override
            public void display(String format) {
                result.display(format);
            }
        };
    }
}