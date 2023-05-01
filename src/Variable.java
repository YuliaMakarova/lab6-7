public class Variable implements Expression {
    private final String name_; // имя переменной
    public Variable(String name) {
        name_ = name;
    }

    public String getName() {
        return name_;
    }

    @Override
    public double evaluate() { // реализация метода «вычислить»
        return 0.0;
    }

    @Override
    public Expression transform(Transformer tr) {
        return tr.transformVariable(this);
    }

    @Override
    public String toString() {
        return name_;
    }
}
