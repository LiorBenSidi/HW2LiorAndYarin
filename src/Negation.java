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

    @Override
    public String toString() {
            return "(-" + function.toString() + ")";
    }
}