public class Negation extends Function {
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

    /*
    @Override
    public double bisectionMethod(double a, double b, double epsilon) {
        return -function.bisectionMethod(a, b, epsilon);
    }
     */

    /*
    @Override
    public double bisectionMethod(double a, double b) {
        return -function.bisectionMethod(a, b);
    }
     */

    @Override
    public double newtonRaphsonMethod(double a, double epsilon) {
        return -function.newtonRaphsonMethod(a, epsilon);
    }

    /*
    @Override
    public double newtonRaphsonMethod(double a) {
        return -function.newtonRaphsonMethod(a);
    }
     */

    /*
    @Override
    public Polynomial taylorPolynomial(int n) {
        Polynomial result = function.taylorPolynomial(n);
        ItemInPolynomial[] polynomial = result.getPolynomial();

        // Negate the coefficients of the polynomial
        for (ItemInPolynomial item : polynomial) {
            item.setCoefficient(-item.getCoefficient());
        }

        return new Polynomial(polynomial);
    }
     */
    @Override
    public String toString() {
        String[] temp = function.toString().split("");
            return "(-" + function.toString() + ")";
    }
}