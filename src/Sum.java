public class Sum extends Function {
    private final Function f, g;

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
        return new Sum(f.derivative(), g.derivative());
    }

    @Override
    public String toString() {
        return "(" + f.toString() + " + " + g.toString() + ")";
    }

}
