/**
 * A class that represents a function that calculates the power of the function.
 * Inherits from the Function abstract class.
 */
public class Power extends Function {
    private final Function f;
    private final int n;

    public Power(Function f, int n) {
        this.f = f;
        this.n = n;
    }

    /**
     * Computes the value of the power function at a given value.
     *
     * @param x The given value
     * @return The result of evaluating the power function at the input value
     */
    @Override
    public double valueAt(double x) {
        return Math.pow(f.valueAt(x), n);
    }

    /**
     * Computes the derivative of the power function.
     *
     * @return Returns the derivative function of the power function
     */
    @Override
    public Function derivative() {
        if (n == 1) {
            return f.derivative();
        } else {
            return new MultiProduct(new Constant(n), new Power(f, n - 1), f.derivative());
        }
    }

    /**
     * Returns the string representation of the power function.
     *
     * @return The string representation of the power function
     */
    @Override
    public String toString() {
        return "(" + f.toString() + "^" + n + ")";
    }
}