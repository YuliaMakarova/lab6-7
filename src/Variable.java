public class Variable extends Expression {
    private final String name_; // имя переменной
    public Variable(String name) {
        name_ = name;
    }

    public String getName() {
        return name_;
    }

    @Override
    public double evaluate() { // реализация виртуального метода «вычислить»
        return 0.0;
    }
}
