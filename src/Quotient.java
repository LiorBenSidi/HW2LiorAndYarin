public class Quotient implements Function {
    private final Function numerator;
    private final Function denominator;

    public Quotient(Function numerator, Function denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public double valueAt(double x) {
        double numeratorValue = numerator.valueAt(x);
        double denominatorValue = denominator.valueAt(x);
        return numeratorValue / denominatorValue;
    }

    @Override
    public Function derivative() {
        Function numeratorDerivative = numerator.derivative();
        Function denominatorDerivative = denominator.derivative();

        // (f * g' - g * f') / (g * g)
        Function numeratorTerm1 = new Product(numeratorDerivative, denominator);
        Function numeratorTerm2 = new Product(denominatorDerivative , numerator);
        numeratorDerivative = new Difference(numeratorTerm1, numeratorTerm2);

        Function denominatorTerm = new Power(denominator, 2);
        return new Quotient(numeratorDerivative, denominatorTerm);
    }

    @Override
    public double bisectionMethod(double a, double b, double epsilon) {
        return (a + b) / 2;
    }

    @Override
    public double bisectionMethod(double a, double b) {
        return bisectionMethod(a, b, Math.pow(10, -5));
    }

    @Override
    public double newtonRaphsonMethod(double a, double epsilon) {
        while (!(Math.abs(this.valueAt(a)) < epsilon)) {
            a = withdrawal(a);
        }
        return a;
    }

    @Override
    public double newtonRaphsonMethod(double a) {
        return newtonRaphsonMethod(a, Math.pow(10, -5));
    }

    @Override
    public Polynomial taylorPolynomial(int n) {
        return new Polynomial(new ItemInPolynomial[]{new ItemInPolynomial(0.0, 0)});
    }

    @Override
    public String toString() {
        return "(" + numerator.toString() + " / " + denominator.toString() + ")";
    }

    private double withdrawal(double x) {
        double fx = valueAt(x);
        double dfx = derivative().valueAt(x);
        return x - (fx / dfx);
    }
}
