public class Main {
    public static void main(String[] args) {
//------------------------------------------------------------------------------
        Expression e1 = new Number(1.234);
        Expression e2 = new Number(-1.234);
        Expression e3 = new BinaryOperation(e1, BinaryOperation.DIV, e2);
        System.out.println(e3.evaluate());
//------------------------------------------------------------------------------
        Expression n32 = new Number(32.0);
        Expression n16 = new Number(16.0);
        Expression minus = new BinaryOperation(n32, BinaryOperation.MINUS, n16);
        Expression callSqrt = new FunctionCall("sqrt", minus);
        Expression n2 = new Number(2.0);
        Expression mult = new BinaryOperation(n2, BinaryOperation.MUL, callSqrt);
        Expression callAbs = new FunctionCall("abs", mult);
        System.out.println(callAbs.evaluate());
//------------------------------------------------------------------------------
    }
}