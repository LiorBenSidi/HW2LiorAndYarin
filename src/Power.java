public class Power extends Function {
    private final Function f;
    private final int n;

    public Power(Function f, int n) {
        this.f = f;
        this.n = n;
    }

    @Override
    public double valueAt(double x) {
        return Math.pow(f.valueAt(x), n);
    }

    @Override
    public Function derivative() {
        if(n == 1) {
            return f.derivative();
        } else {
            return new MultiProduct(new Constant(n), new Power(f, n - 1), f.derivative());
        }
    }

    @Override
    public double newtonRaphsonMethod(double a, double epsilon) {
        while (!(Math.abs(this.valueAt(a)) < epsilon)) {
            a = withdrawal(a);
        }
        return a;
    }

    @Override
    public String toString() {
        return "(" + f.toString() + "^" + n + ")";
    }

    private double withdrawal(double x) {
        double fx = valueAt(x);
        double dfx = derivative().valueAt(x);
        return x - (fx / dfx);
    }
}