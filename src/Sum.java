/**
 * Represents a function that computes the sum of two functions.
 */
public class Sum extends Function {
    private final Function f, g;


    /**
     * Constructs a Sum object with the given functions to be summed.
     *
     * @param f the first function
     * @param g the second function
     */
    public Sum(Function f, Function g) {
        this.f = f;
        this.g = g;
    }

    /**
     * Computes the value of the sum function at a given input value.
     *
     * @param x the input value
     * @return the result of evaluating the sum function at the input value
     */
    @Override
    public double valueAt(double x) {
        return f.valueAt(x) + g.valueAt(x);
    }

    /**
     * Computes the derivative of the sum function by taking the derivatives of the individual functions.
     *
     * @return the derivative of the sum function as a Function object
     */
    @Override
    public Function derivative() {
        return new Sum(f.derivative(), g.derivative());
    }

    /**
     * Returns the string representation of the sum function.
     *
     * @return the string representation of the sum function
     */
    @Override
    public String toString() {
        return "(" + f.toString() + " + " + g.toString() + ")";
    }

}
