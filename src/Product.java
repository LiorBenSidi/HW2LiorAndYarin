/**
 * Represents a function that computes the product of two functions.
 */
public class Product extends Function {
    private final Function f, g;

    /**
     * Constructs a Product object with the given functions.
     *
     * @param f the first function
     * @param g the second function
     */
    public Product(Function f, Function g) {
        this.f = f;
        this.g = g;
    }

    /**
     * Computes the value of the product function at a given input value.
     *
     * @param x the input value
     * @return the result of evaluating the product function at the input value
     */
    @Override
    public double valueAt(double x) {
        return f.valueAt(x) * g.valueAt(x);
    }

    /**
     * Computes the derivative of the product function using the product rule.
     *
     * @return the derivative of the product function as a Function object
     */
    @Override
    public Function derivative() {
        return new Sum(new Product(f.derivative(), g), new Product(g.derivative() , f));
    }

    /**
     * Returns the string representation of the product function.
     *
     * @return the string representation of the product function
     */
    @Override
    public String toString() {
        return "(" + f.toString() + " * " + g.toString() + ")";
    }
}