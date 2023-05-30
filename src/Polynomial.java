public class Polynomial implements Function {
    private final ItemInPolynomial[] polynomial;

    public Polynomial(ItemInPolynomial[] polynomial) {
        this.polynomial = polynomial;
    }

    @Override
    public double valueAt(double x) {
        double result = 0.0;
        for (ItemInPolynomial term : polynomial) {
            result += term.getCoefficient() * Math.pow(x, term.getExponent());
        }
        return result;
    }

    @Override
    public Function derivative() {
        ItemInPolynomial[] derivativeTerms = new ItemInPolynomial[polynomial.length];
        for (int i = 0; i < polynomial.length; i++) {
            ItemInPolynomial term = polynomial[i];
            double coefficient = term.getCoefficient() * term.getExponent();
            int exponent = term.getExponent() - 1;
            derivativeTerms[i] = new ItemInPolynomial(coefficient, exponent);
        }
        return new Polynomial(derivativeTerms);
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
        ItemInPolynomial[] taylorTerms = new ItemInPolynomial[n + 1];
        for (int i = 0; i <= n; i++) {
            double coefficient = i < polynomial.length ? polynomial[i].getCoefficient() : 0.0;
            taylorTerms[i] = new ItemInPolynomial(coefficient, i);
        }
        return new Polynomial(taylorTerms);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < polynomial.length; i++) {
            ItemInPolynomial term = polynomial[i];
            double coefficient = term.getCoefficient();
            int exponent = term.getExponent();

            if (coefficient != 0.0) {
                if (coefficient > 0 && i > 0) {
                    sb.append(" + ");
                } else if (coefficient < 0) {
                    sb.append(" - ");
                    coefficient = Math.abs(coefficient);
                }

                if (coefficient != 1.0 || exponent == 0) {
                    sb.append(coefficient);
                }

                if (exponent > 0) {
                    sb.append("x");

                    if (exponent > 1) {
                        sb.append("^").append(exponent);
                    }
                }
            }
        }
        return sb.toString();
    }

    private double withdrawal(double x) {
        double fx = valueAt(x);
        double dfx = derivative().valueAt(x);
        return x - (fx / dfx);
    }
}
