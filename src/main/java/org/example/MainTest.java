package org.example;


//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.testng.AssertJUnit.fail;
//
//import java.io.IOException;

public class MainTest {
    public static void main(String[] args) {
        testInitAndShow();

        testSaveAndRestore();

        testDisplay();
    }

    public static void testInitAndShow() {
        System.out.println("Testing init and show methods:");
        Calc calc = new Calc();
        double v = 10.5;
        double r1 = 2.3;
        double r2 = 4.7;
        double r3 = 6.1;
        double r4 = 8.9;
        calc.init(v, r1, r2, r3, r4);
        calc.show();
        System.out.println();
    }

    public static void testSaveAndRestore() {
        System.out.println("Testing save and restore methods:");
        Calc calc = new Calc();
        double v = 10.5;
        double r1 = 2.3;
        double r2 = 4.7;
        double r3 = 6.1;
        double r4 = 8.9;
        calc.init(v, r1, r2, r3, r4);
        try {
            calc.save();
            calc.restore();
            calc.show();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();
    }

    public static void testDisplay() {
        System.out.println("Testing display methods:");
        Calc calc = new Calc();
        double v = 10.5;
        double r1 = 2.3;
        double r2 = 4.7;
        double r3 = 6.1;
        double r4 = 8.9;
        calc.init(v, r1, r2, r3, r4);

        Displayable displayable = calc.createDisplayable();
        System.out.println("Displaying in string format:");
        System.out.println();
        displayable.display("String");
        System.out.println("Displaying in table format:");
        System.out.println();
        displayable.display("Table");
    }
}