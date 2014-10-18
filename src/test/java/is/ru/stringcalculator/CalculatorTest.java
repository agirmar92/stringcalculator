package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {
    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

    @Test
    public void testEmptyString() throws Exception {
	assertEquals(0, Calculator.add(""));
    }

    @Test
    public void testOneNumber() throws Exception {
	assertEquals(1, Calculator.add("1"));
    }

    @Test
    public void testTwoNumbers() throws Exception {
	assertEquals(3, Calculator.add("1,2"));
    }	

    @Test
    public void testMultipleNumbers() throws Exception {
    	assertEquals(6, Calculator.add("1,2,3"));
    }

    @Test(expected = Exception.class)
    public void testNegativeNumbers() throws Exception {
	assertEquals("Negatives not allowed: -1,-4", Calculator.add("-1,3,-4"));
    }

    @Test(expected = Exception.class)
    public void testOneNegativeNumber() throws Exception {
	assertEquals("Negatives not allowed: -23", Calculator.add("-23"));
    }

    @Test
    public void testThreeNumbersWithNewLine() throws Exception {
	assertEquals(6, Calculator.add("1\n2,3"));
    }

    @Test
    public void testTwoNumbersWithNewLine() throws Exception {
	assertEquals(6, Calculator.add("3\n3"));
    }

    @Test
    public void testDifferentDelimeters() throws Exception {
	assertEquals(5, Calculator.add("//;\n3;2"));
	assertEquals(15, Calculator.add("//&\n5&3&3&4"));
    }

    @Test
    public void ignoreNumbersGreaterThan1000() throws Exception {
	assertEquals(0, Calculator.add("1001"));
	assertEquals(2, Calculator.add("1001,2"));
    }
}
