public class Sum implements Function {
    private final Function f;
    private final Function g;

    public Sum(Function f, Function g) {
        this.f = f;
        this.g = g;
    }

    @Override
    public double valueAt(double x) {
        return f.valueAt(x) + g.valueAt(x);
    }

    @Override
    public Function derivative() {
        Function sum1 = new Sum(f.derivative(), g.derivative());
        return sum1;
    }

    @Override
    public double bisectionMethod(double a, double b, double epsilon) {
        double left = a;
        double right = b;
        double mid;
        while (right - left > epsilon) {
            mid = (left + right) / 2;
            if (valueAt(left) * valueAt(mid) > 0) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return (left + right) / 2;
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

        ItemInPolynomial[] sumTerms = new ItemInPolynomial[n + 1];
        for (int i = 0; i <= n; i++) {
            double coefficient = 0.0;
            if (i < fTaylor.getPolynomial().length) {
                coefficient += fTaylor.getPolynomial()[i].getCoefficient();
            }
            if (i < gTaylor.getPolynomial().length) {
                coefficient += gTaylor.getPolynomial()[i].getCoefficient();
            }
            sumTerms[i] = new ItemInPolynomial(coefficient, i);
        }

        return new Polynomial(sumTerms);
    }

    @Override
    public String toString() {
        return "(" + f.toString() + " + " + g.toString() + ")";
    }

    private double withdrawal(double x) {
        double fx = valueAt(x);
        double dfx = derivative().valueAt(x);
        return x - (fx / dfx);
    }
}
