public class Negation implements Function {
    private final Function function;

    public Negation(Function function) {
        this.function = function;
    }

    @Override
    public double valueAt(double x) {
        return -function.valueAt(x);
    }

    @Override
    public Function derivative() {
        return new Negation(function.derivative());
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
        Polynomial functionTaylor = function.taylorPolynomial(n);
        ItemInPolynomial[] negationTerms = new ItemInPolynomial[n + 1];

        for (int i = 0; i <= n; i++) {
            double coefficient = -functionTaylor.getCoefficient(i);
            negationTerms[i] = new ItemInPolynomial(coefficient, i);
        }

        return new Polynomial(negationTerms);
    }

    @Override
    public String toString() {
        return "-(" + function.toString() + ")";
    }

    private double withdrawal(double x) {
        double fx = valueAt(x);
        double dfx = derivative().valueAt(x);
        return x - (fx / dfx);
    }
}
