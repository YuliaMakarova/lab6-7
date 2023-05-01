public class Number extends Expression {
    private double value_; // само вещественное число

    public Number(double value) {
        value_ = value;
    }

    public double getValue() {
        return value_;
    }

    @Override
    public double evaluate() { // реализация виртуального метода «вычислить»
        return value_;
    }
}
