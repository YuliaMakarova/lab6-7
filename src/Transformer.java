public interface Transformer {  //Паттерн Visitor
    Expression transformNumber(Number num);
    Expression transformBinaryOperation(BinaryOperation binOp);
    Expression transformFunctionCall(FunctionCall funCall);
    Expression transformVariable(Variable var);
}
