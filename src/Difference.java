public class Difference extends Function {
    private final Function f;
    private final Function g;

    public Difference(Function f, Function g) {
        this.f = f;
        this.g = g;
    }

    @Override
    public double valueAt(double x) {
        return f.valueAt(x) - g.valueAt(x);
    }

    @Override
    public Function derivative() {
        return new Difference(f.derivative(), g.derivative());
    }

    /*
    @Override
    public double bisectionMethod(double a, double b, double epsilon) {
        return (a + b) / 2;
    }
     */

    /*
    @Override
    public double bisectionMethod(double a, double b) {
        return bisectionMethod(a, b, Math.pow(10, -5));
    }
     */

    @Override
    public double newtonRaphsonMethod(double a, double epsilon) {
        while (!(Math.abs(this.valueAt(a)) < epsilon)) {
            a = withdrawal(a);
        }
        return a;
    }

    /*
    @Override
    public double newtonRaphsonMethod(double a) {
        return newtonRaphsonMethod(a, Math.pow(10, -5));
    }
     */

    /*
    @Override
    public Polynomial taylorPolynomial(int n) {
        return new Polynomial(new ItemInPolynomial[]{new ItemInPolynomial(0.0, 0)});
    }
     */

    @Override
    public String toString() {
        return "(" + f.toString() + " - " + g.toString() + ")";
    }

    private double withdrawal(double x) {
        double fx = valueAt(x);
        double dfx = derivative().valueAt(x);
        return x - (fx / dfx);
    }
}