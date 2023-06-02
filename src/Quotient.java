/**
 * Represents a function that computes the quotient of two functions.
 */
public class Quotient extends Function {
    private final Function numerator, denominator;

    /**
     * Constructs a Quotient object with the given numerator and denominator functions.
     *
     * @param numerator   the numerator function
     * @param denominator the denominator function
     */
    public Quotient(Function numerator, Function denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Computes the value of the quotient function at a given input value.
     *
     * @param x the input value
     * @return the result of evaluating the quotient function at the input value
     */
    @Override
    public double valueAt(double x) {
        return numerator.valueAt(x) / denominator.valueAt(x);
    }

    /**
     * Computes the derivative of the quotient function using the quotient rule.
     *
     * @return the derivative of the quotient function as a Function object
     */
    @Override
    public Function derivative() {
        Function numeratorDerivative = numerator.derivative();
        Function denominatorDerivative = denominator.derivative();
        numeratorDerivative = new Difference(new Product(numeratorDerivative, denominator),
                                             new Product(denominatorDerivative, numerator));

        return new Quotient(numeratorDerivative, new Power(denominator, 2));
    }

    /**
     * Returns the string representation of the quotient function.
     *
     * @return the string representation of the quotient function
     */
    @Override
    public String toString() {
        return "(" + numerator.toString() + " / " + denominator.toString() + ")";
    }
}
