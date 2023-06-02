/**
 * A class that represents a function that computes the sum of two functions.
 * Inherits from the Function abstract class.
 */
public class Sum extends Function {
    private final Function f, g;

    public Sum(Function f, Function g) {
        this.f = f;
        this.g = g;
    }

    /**
     * Computes the value of the sum function according to a given input value.
     *
     * @param x The given value
     * @return The result of evaluating the sum function according to a given input value
     */
    @Override
    public double valueAt(double x) {
        return f.valueAt(x) + g.valueAt(x);
    }

    /**
     * Computes the derivative function of the sum function.
     * We do it by taking the derivatives of the individual functions.
     *
     * @return The derivative function of the sum function as a Function object
     */
    @Override
    public Sum derivative() {
        return new Sum(f.derivative(), g.derivative());
    }

    /**
     * Returns the string representation of the sum function.
     *
     * @return The string representation of the sum function
     */
    @Override
    public String toString() {
        return "(" + f.toString() + " + " + g.toString() + ")";
    }

}
