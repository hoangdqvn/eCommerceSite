package demo.test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void add() {
        Calculator calculator = new Calculator();
        int a = 1234;
        int b = 5678;
        int result = calculator.add(a,b);

        int expected = 6912;

        assertEquals(expected,result);
    }
}
