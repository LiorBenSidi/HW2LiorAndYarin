public class Product implements Function {
    private final Function f;
    private final Function g;

    public Product(Function f, Function g) {
        this.f = f;
        this.g = g;
    }

    @Override
    public double valueAt(double x) {
        return f.valueAt(x) * g.valueAt(x);
    }

    @Override
    public Function derivative() {
        Function fDerivative = f.derivative();
        Function gDerivative = g.derivative();
        Function fTimesGDerivative = new Product(f, gDerivative);
        Function gTimesFDerivative = new Product(g, fDerivative);
        return new Sum(fTimesGDerivative, gTimesFDerivative);
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
        Polynomial fTaylor = f.taylorPolynomial(n);
        Polynomial gTaylor = g.taylorPolynomial(n);
        ItemInPolynomial[] productTerms = new ItemInPolynomial[n + 1];

        for (int i = 0; i <= n; i++) {
            double coefficient = 0.0;
            for (int j = 0; j <= i; j++) {
                coefficient += fTaylor.getCoefficient(j) * gTaylor.getCoefficient(i - j);
            }
            productTerms[i] = new ItemInPolynomial(coefficient, i);
        }

        return new Polynomial(productTerms);
    }

    @Override
    public String toString() {
        return "(" + f.toString() + " * " + g.toString() + ")";
    }

    private double withdrawal(double x) {
        double fx = valueAt(x);
        double dfx = derivative().valueAt(x);
        return x - (fx / dfx);
    }
}