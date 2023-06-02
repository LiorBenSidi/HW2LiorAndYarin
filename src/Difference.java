/**
 * A class representing the difference of two functions.
 * Inherits from the Function class.
 */
public class Difference extends Function {
    private final Function f, g;

    /**
     * Constructs a Difference object with the specified functions.
     *
     * @param f the first function
     * @param g the second function
     */
    public Difference(Function f, Function g) {
        this.f = f;
        this.g = g;
    }

    /**
     * Computes the value of the difference of the two functions at the given point.
     *
     * @param x the input value
     * @return the value of the difference of the functions at x
     */
    @Override
    public double valueAt(double x) {
        return f.valueAt(x) - g.valueAt(x);
    }

    /**
     * Computes the derivative of the difference of the two functions.
     *
     * @return the derivative function of the difference
     */
    @Override
    public Function derivative() {
        return new Difference(f.derivative(), g.derivative());
    }

    /**
     * Returns a string representation of the difference of the two functions.
     *
     * @return the string representation of the difference
     */
    @Override
    public String toString() {
        return "(" + f.toString() + " - " + g.toString() + ")";
    }
}