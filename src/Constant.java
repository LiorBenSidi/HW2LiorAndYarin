public class Constant extends Function {
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
    public double newtonRaphsonMethod(double a, double epsilon) {
        return 0.0; // Returns the default value of double.
    }

    @Override
    public String toString() {
        if (isDoubleInt(value)) {
            return "("  + (int) value + ")";
        } else {
            return "(" + value + ")";
        }
    }

    public boolean isDoubleInt(double number) {
        final double TOLERANCE = 1E-5; //select a "tolerance range" for being an integer
        return Math.abs(Math.floor(number) - number) < TOLERANCE;

    }
}