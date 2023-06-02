/**
 * A class representing a constant function.
 */
public class Constant extends Function {
    private final double value;

    public Constant(double value) {
        this.value = value;
    }

    /**
     * Calculates the value of the constant function, which is always equal to its specified value.
     *
     * @param x The value of the constant function.
     * @return the constant value.
     */
    @Override
    public double valueAt(double x) {
        return value;
    }

    /**
     * Returns the derivative of the constant function, which is always equals to 0.
     *
     * @return The derivative function (a constant with 0 for its value).
     */
    @Override
    public Function derivative() {
        return new Constant(0.0);
    }

    /**
     * Returns a string representation of the constant function.
     *
     * @return a string representation of the constant value (rounded to integer if it is an integer).
     */
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