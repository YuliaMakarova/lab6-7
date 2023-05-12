import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return Double.compare(number.value_, value_) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value_);
    }
}
