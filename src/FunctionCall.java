public class FunctionCall implements Expression {
    private final String name_; // имя функции
    private final Expression arg_; // ее аргумент
    public FunctionCall(String name, Expression arg) {
        name_ = name;
        arg_ = arg;
        assert(arg_ != null);
        assert(name_.equals("sqrt") || name_.equals("abs")); // разрешены только вызов sqrt и abs
    }

    public String getName() {
        return name_;
    }

    public Expression getArg() {
        return arg_;
    }

    @Override
    public double evaluate() { // реализация метода «вычислить»
        if (name_.equals("sqrt")) {
            return Math.sqrt(arg_.evaluate()); // либо вычисляем корень квадратный
        } else {
            return Math.abs(arg_.evaluate()); // либо модуль - остальные функции запрещены
        }
    }

    @Override
    public Expression transform(Transformer tr) {
        return tr.transformFunctionCall(this);
    }

    @Override
    public String toString() {
        return name_ + "(" + arg_.toString() + ")";
    }
}
