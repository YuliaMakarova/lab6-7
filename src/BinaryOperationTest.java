import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryOperationTest {
    private final double DELTA = 0.0000001;
    private BinaryOperation plus;
    private BinaryOperation minus;
    private BinaryOperation mul;
    private BinaryOperation div;
    private BinaryOperation complexOperation;
    private BinaryOperation varOperation;
    @Before
    public void init() {
        plus = new BinaryOperation(new Number(2), BinaryOperation.PLUS, new Number(3));
        minus = new BinaryOperation(new Number(5), BinaryOperation.MINUS, new Number(3));
        mul = new BinaryOperation(new Number(2), BinaryOperation.MUL, new Number(3));
        div = new BinaryOperation(new Number(10), BinaryOperation.DIV, new Number(5));
        complexOperation = new BinaryOperation(mul, BinaryOperation.DIV, div);
        varOperation = new BinaryOperation(new Number(17), BinaryOperation.PLUS, new Variable("a"));
    }

    @Test
    public void testPlus() {
        assertEquals(5.0, plus.evaluate(), DELTA);
    }

    @Test
    public void testMinus() {
        assertEquals(2.0, minus.evaluate(), DELTA);
    }

    @Test
    public void testMultiply() {
        assertEquals(6.0, mul.evaluate(), DELTA);
    }

    @Test
    public void testDivide() {
        assertEquals(2.0, div.evaluate(), DELTA);
    }

    @Test
    public void testComplexOperation() {
        assertEquals(3.0, complexOperation.evaluate(), DELTA);
    }
    @Test
    public void testVarOperation() {
        assertEquals(17.0, varOperation.evaluate(), DELTA);
    }

    @Test
    public void testToString() {
        assertEquals("17.0+a", varOperation.toString());
    }
}