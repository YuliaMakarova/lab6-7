import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FoldConstantsTest {
    private final double DELTA = 0.0000001;
    private Expression num;
    private Expression binOp1;
    private Expression binOp2;
    private Expression binOp3;
    private Expression binOp4;
    private Expression funCall1;
    private Expression funCall2;
    private Expression var;

    @Before
    public void init() {
        num = new Number(5.0);

        Expression left = new Number(10.0);
        Expression right = new Number(5.0);
        binOp1 = new BinaryOperation(left, BinaryOperation.PLUS, right);
        binOp2 = new BinaryOperation(left, BinaryOperation.MINUS, right);
        binOp3 = new BinaryOperation(left, BinaryOperation.MUL, right);
        binOp4 = new BinaryOperation(left, BinaryOperation.DIV, right);

        Expression arg1 = new Number(4.0);
        funCall1 = new FunctionCall("sqrt", arg1);
        Expression arg2 = new Number(-4.0);
        funCall2 = new FunctionCall("abs", arg2);

        var = new Variable("x");
    }

    @Test
    public void testTransformNumber() {
        Expression result = new FoldConstants().transformNumber((Number) num);
        assertEquals(num, result);
    }

    @Test
    public void testTransformBinaryOperation() {
        Expression result = new FoldConstants().transformBinaryOperation((BinaryOperation) binOp1);
        assertTrue(result instanceof Number);
        assertEquals(15.0, result.evaluate(), DELTA);

        result = new FoldConstants().transformBinaryOperation((BinaryOperation) binOp2);
        assertTrue(result instanceof Number);
        assertEquals(5.0, result.evaluate(), DELTA);

        result = new FoldConstants().transformBinaryOperation((BinaryOperation) binOp3);
        assertTrue(result instanceof Number);
        assertEquals(50.0, result.evaluate(), DELTA);

        result = new FoldConstants().transformBinaryOperation((BinaryOperation) binOp4);
        assertTrue(result instanceof Number);
        assertEquals(2.0, result.evaluate(), DELTA);
    }

    @Test
    public void testTransformFunctionCall() {
        Expression result = new FoldConstants().transformFunctionCall((FunctionCall) funCall1);
        assertTrue(result instanceof Number);
        assertEquals(2.0, result.evaluate(), DELTA);

        result = new FoldConstants().transformFunctionCall((FunctionCall) funCall2);
        assertTrue(result instanceof Number);
        assertEquals(4.0, result.evaluate(), DELTA);
    }

    @Test
    public void testTransformVariable() {
        Expression result = new FoldConstants().transformVariable((Variable) var);
        assertTrue(result instanceof Variable);
        assertEquals("x", ((Variable) result).getName());
    }
}