/**
 * A class that represents a function that computes the product of two functions.
 * Inherits from the Function abstract class.
 */
public class Product extends Function {
    private final Function f, g;

    public Product(Function f, Function g) {
        this.f = f;
        this.g = g;
    }

    /**
     * Computes the value of the product function at a given input value.
     *
     * @param x The given value
     * @return The result of evaluating the product function at the input value
     */
    @Override
    public double valueAt(double x) {
        return f.valueAt(x) * g.valueAt(x);
    }

    /**
     * Computes the derivative function of the product function using the product rule.
     *
     * @return The derivative function of the product function
     */
    @Override
    public Sum derivative() {
        return new Sum(new Product(f.derivative(), g), new Product(g.derivative() , f));
    }

    /**
     * Returns the string representation of the product function.
     *
     * @return The string representation of the product function
     */
    @Override
    public String toString() {
        return "(" + f.toString() + " * " + g.toString() + ")";
    }
}