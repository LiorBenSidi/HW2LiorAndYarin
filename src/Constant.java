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
        return a;
    }

    @Override
    public Polynomial taylorPolynomial(int n) {
        return new Polynomial(new ItemInPolynomial[]{new ItemInPolynomial(value, 0)});
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}