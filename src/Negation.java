/**
 * Represents a function that is the negation of another function.
 */
public class Negation extends Function {
    private final Function function;

    /**
     * Constructs a Negation object with the given function.
     *
     * @param function the function to be negated
     */
    public Negation(Function function) {
        this.function = function;
    }

    /**
     * Computes the value of the negation function at a given input value.
     *
     * @param x the input value
     * @return the result of evaluating the negation function at the input value
     */
    @Override
    public double valueAt(double x) {
        return -function.valueAt(x);
    }

    /**
     * Computes the derivative of the negation function.
     *
     * @return the derivative of the negation function as a Function object
     */
    @Override
    public Function derivative() {
        return new Negation(function.derivative());
    }

    /**
     * Returns the string representation of the negation function.
     *
     * @return the string representation of the negation function
     */
    @Override
    public String toString() {
            return "(-" + function.toString() + ")";
    }
}