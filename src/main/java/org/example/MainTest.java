package org.example;


//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.testng.AssertJUnit.fail;
//
//import java.io.IOException;

public class MainTest {
    public static void main(String[] args) {
        // Test initAndShowResult
        System.out.println("Test initAndShowResult:");
        Calc.initAndShowResult(10.0, 2.0, 3.0, 4.0, 5.0);

        // Test save and restore
        try {
            System.out.println("\nTesting save and restore:");
            Calc.save();
            Calc.restore();
            System.out.println("Restored object:");
            Calc.show();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test createDisplayable
        System.out.println("\nTesting createDisplayable:");
        Displayable displayable = Calc.createDisplayable();
        displayable.display("t");

        // Test DirectCurrent
        System.out.println("\nTesting DirectCurrent:");
        DirectCurrent directCurrent = new DirectCurrent();
        Item2d result = directCurrent.calculateDirectCurrent(10.0, 2.0, 3.0, 4.0, 5.0);
        result.display("t");

        // Test SomeNewClass
        System.out.println("\nTesting SomeNewClass:");
        SomeNewClass someNewClass = new SomeNewClass("Sample data");
        someNewClass.display("s");
    }
}