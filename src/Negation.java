/**
 * A class that represents a function that is the negation of the given function.
 * Inherits from the Function abstract class.
 */
public class Negation extends Function {
    private final Function function;

    public Negation(Function function) {
        this.function = function;
    }

    /**
     * Computes the value of the negation function at a given value.
     *
     * @param x The given value.
     * @return The result of evaluating the negation function at the given value
     */
    @Override
    public double valueAt(double x) {
        return -function.valueAt(x);
    }

    /**
     * Computes the derivative of the negation function.
     *
     * @return The derivative function of the negation function
     */
    @Override
    public Negation derivative() {
        return new Negation(function.derivative());
    }

    /**
     * Returns the string representation of the negation function.
     *
     * @return The string representation of the negation function
     */
    @Override
    public String toString() {
            return "(-" + function.toString() + ")";
    }
}