public class Power extends Function {
    private final Function f;
    private final int n;

    /**
     * Constructs a Power object with the given function and power.
     *
     * @param f the base function
     * @param n the power to raise the function to
     */
    public Power(Function f, int n) {
        this.f = f;
        this.n = n;
    }

    /**
     * Computes the value of the power function at a given input value.
     *
     * @param x the input value
     * @return the result of evaluating the power function at the input value
     */
    @Override
    public double valueAt(double x) {
        return Math.pow(f.valueAt(x), n);
    }

    /**
     * Computes the derivative of the power function.
     *
     * @return the derivative of the power function as a Function object
     */
    @Override
    public Function derivative() {
        if(n == 1) {
            return f.derivative();
        } else {
            return new MultiProduct(new Constant(n), new Power(f, n - 1), f.derivative());
        }
    }

    /**
     * Returns the string representation of the power function.
     *
     * @return the string representation of the power function
     */
    @Override
    public String toString() {
        return "(" + f.toString() + "^" + n + ")";
    }
}