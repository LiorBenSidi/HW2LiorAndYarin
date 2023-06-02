public class Quotient extends Function {
    private final Function numerator, denominator;

    public Quotient(Function numerator, Function denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public double valueAt(double x) {
        return numerator.valueAt(x) / denominator.valueAt(x);
    }

    @Override
    public Function derivative() {
        Function numeratorDerivative = numerator.derivative();
        Function denominatorDerivative = denominator.derivative();
        numeratorDerivative = new Difference(new Product(numeratorDerivative, denominator),
                                             new Product(denominatorDerivative, numerator));

        return new Quotient(numeratorDerivative, new Power(denominator, 2));
    }

    @Override
    public String toString() {
        return "(" + numerator.toString() + " / " + denominator.toString() + ")";
    }
}
