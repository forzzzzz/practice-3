package org.example;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.AssertJUnit.fail;

import java.io.IOException;

public class MainTest {

    @Test
    public void testInit() {
        Calc calc = new Calc();

        assertEquals("100000001000100000000000000000000000000000000000000000000000000", calc.init(10.0, 1.0, 1.0, 1.0, 1.0));
        assertEquals("100000001000100000000000000000000000000000000000000000000000000", calc.init(20.0, 2.0, 2.0, 2.0, 2.0));
        assertEquals("100000001000100000000000000000000000000000000000000000000000000", calc.init(30.0, 3.0, 3.0, 3.0, 3.0));
        assertEquals("100000001000100000000000000000000000000000000000000000000000000", calc.init(40.0, 4.0, 4.0, 4.0, 4.0));
        assertEquals("100000001000100000000000000000000000000000000000000000000000000", calc.init(50.0, 5.0, 5.0, 5.0, 5.0));
    }

    @Test
    public void testSaveAndRestore() {
        Calc calc = new Calc();

        calc.init(Math.random() * 360.0,
                Math.random() * 360.0,
                Math.random() * 360.0,
                Math.random() * 360.0,
                Math.random() * 360.0);

        try {
            calc.save();
        } catch (IOException e) {
            fail("Serialization error: " + e);
        }

        try {
            calc.restore();
        } catch (Exception e) {
            fail("Deserialization error: " + e);
        }

        assertEquals("101010", calc.getResult().getBinaryCurrent());
    }
}