public class Number implements Expression {
    private double value_; // само вещественное число

    public Number(double value) {
        value_ = value;
    }

    public double getValue() {
        return value_;
    }

    @Override
    public double evaluate() { // реализация метода «вычислить»
        return value_;
    }

    @Override
    public Expression transform(Transformer tr) {
        return tr.transformNumber(this);
    }

    @Override
    public String toString() {
        return Double.toString(value_);
    }
}
