public class BinaryOperation implements Expression {
    public static final int PLUS = '+';
    public static final int MINUS = '-';
    public static final int DIV = '/';
    public static final int MUL = '*';

    private final Expression left_; // указатель на левый операнд
    private final Expression right_; // указатель на правый операнд
    private int op_; // символ операции

    public BinaryOperation(Expression left, int op, Expression right) {
        left_ = left;
        op_ = op;
        right_ = right;
        assert(left_ != null && right_ != null);
    }

    public Expression getLeft() {
        return left_;
    }

    public Expression getRight() {
        return right_;
    }

    public int getOperation() {
        return op_;
    }

    @Override
    public double evaluate() { // реализация метода «вычислить»
        double left = left_.evaluate(); // вычисляем левую часть
        double right = right_.evaluate(); // вычисляем правую часть
        switch (op_) { // в зависимости от вида операции, складываем, вычитаем,
            // или делим левую и правую части
            case PLUS:
                return left + right;
            case MINUS:
                return left - right;
            case DIV:
                return left / right;
            case MUL:
                return left * right;
        }
        return 0.0;
    }

    @Override
    public Expression transform(Transformer tr) {
        return tr.transformBinaryOperation(this);
    }

    @Override
    public String toString() {
        String op = "";
        switch (op_) {
            case PLUS:
                op = "+";
                break;
            case MINUS:
                op = "-";
                break;
            case DIV:
                op = "/";
                break;
            case MUL:
                op = "*";
                break;
        }
        return left_.toString() + op + right_.toString();
    }
}
