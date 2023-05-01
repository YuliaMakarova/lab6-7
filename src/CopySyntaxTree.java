public class CopySyntaxTree implements Transformer {
    @Override
    public Expression transformNumber(Number num) {
        return new Number(num.getValue());
    }

    @Override
    public Expression transformBinaryOperation(BinaryOperation binOp) {
        Expression newLeft = binOp.getLeft().transform(this);
        Expression newRight = binOp.getRight().transform(this);
        return new BinaryOperation(newLeft, binOp.getOperation(), newRight);
    }

    @Override
    public Expression transformFunctionCall(FunctionCall funCall) {
        Expression newArg = funCall.getArg().transform(this);
        return new FunctionCall(funCall.getName(), newArg);
    }

    @Override
    public Expression transformVariable(Variable var) {
        return new Variable(var.getName());
    }
}
