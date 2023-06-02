/**
 * A class representing a constant mathematical function.
 */
public class Constant extends Function {
    private final double value;

    /**
     * Constructs a constant function with the specified value.
     *
     * @param value the value of the constant
     */
    public Constant(double value) {
        this.value = value;
    }

    /**
     * Calculates the value of the constant function, which is always equal to its specified value.
     *
     * @param x the input value (ignored)
     * @return the constant value
     */
    @Override
    public double valueAt(double x) {
        return value;
    }

    /**
     * Returns the derivative of the constant function, which is always zero.
     *
     * @return the derivative function (a constant with value zero)
     */
    @Override
    public Function derivative() {
        return new Constant(0.0);
    }

    /**
     * Returns a string representation of the constant function.
     *
     * @return a string representation of the constant value, rounded to the nearest integer if it is an integer
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