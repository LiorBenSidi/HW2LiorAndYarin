public class Constant implements Function {
    private final double value;

    public Constant(double value) {
        this.value = value;
    }

    @Override
    public double valueAt(double x) {
        return value;
    }

    @Override
    public Function derivative() {
        return new Constant(0.0);
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
        return a;
    }

    @Override
    public double newtonRaphsonMethod(double a) {
        return newtonRaphsonMethod(a, Math.pow(10, -5));
    }

    @Override
    public Polynomial taylorPolynomial(int n) {
        ItemInPolynomial[] terms = new ItemInPolynomial[1];
        terms[0] = new ItemInPolynomial(value, 0);
        return new Polynomial(terms);
    }

    @Override
    public String toString() {
        if (isDoubleInt(value)) {
            return "("  + String.valueOf((int) value) + ")";
        } else {
            return "(" + String.valueOf(value) + ")";
        }
    }
    public boolean isDoubleInt(double d) {
        //select a "tolerance range" for being an integer
        double TOLERANCE = 1E-5;
        //do not use (int)d, due to weird floating point conversions!
        return Math.abs(Math.floor(d) - d) < TOLERANCE;
    }
}