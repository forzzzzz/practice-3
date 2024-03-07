package org.example;


//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.testng.AssertJUnit.fail;
//
//import java.io.IOException;

public class MainTest {
    public static void main(String[] args) {
        Calc calc = new Calc();

        System.out.println("Testing initialization and display of randomly generated values:");
        calc.init(Math.random() * 360.0,
                Math.random() * 360.0,
                Math.random() * 360.0,
                Math.random() * 360.0,
                Math.random() * 360.0);
        calc.show();

        System.out.println("\nTesting save and restore functionality:");
        try {
            System.out.println("Saving current state...");
            calc.save();
            System.out.println("Restoring last saved state...");
            calc.restore();
            calc.show();
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }

        System.out.println("\nTesting setResult and getResult:");
        Item2d customItem = new Item2d("1010101010");
        calc.setResult(customItem);
        System.out.println("Custom result:");
        calc.show();

        System.out.println("\nTesting random generation:");
        calc.init(Math.random() * 360.0,
                Math.random() * 360.0,
                Math.random() * 360.0,
                Math.random() * 360.0,
                Math.random() * 360.0);
        calc.show();

        System.out.println("\nTesting creation of Displayable object:");
        Displayable displayable = calc.createDisplayable();
        displayable.display();


        System.out.println("\nTesting completed.");
    }
}