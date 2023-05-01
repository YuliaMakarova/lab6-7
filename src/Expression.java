public interface Expression {   //базовая абстрактная структура
    double evaluate();          //абстрактный метод «вычислить»
    Expression transform(Transformer tr);
}