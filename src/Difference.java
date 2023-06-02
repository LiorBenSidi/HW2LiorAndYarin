public class Difference extends Function {
    private final Function f, g;

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

    @Override
    public String toString() {
        return "(" + f.toString() + " - " + g.toString() + ")";
    }
}