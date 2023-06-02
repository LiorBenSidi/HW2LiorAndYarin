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
    public String toString() {
        final double TOLERANCE = 1E-5; //select a "tolerance range" for being an integer
        boolean isDoubleInt = Math.abs(Math.floor(value) - value) < TOLERANCE;
        if (isDoubleInt) {
            return "("  + (int) value + ")";
        } else {
            return "(" + value + ")";
        }
    }
}