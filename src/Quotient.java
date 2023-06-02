/**
 * A class that represents a function that computes the quotient of two functions.
 * Inherits from the Function abstract class.
 */
public class Quotient extends Function {
    private final Function numerator, denominator;

    public Quotient(Function numerator, Function denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Computes the value of the quotient function at a given value.
     *
     * @param x The given value
     * @return The result of evaluating the quotient function at the input value
     */
    @Override
    public double valueAt(double x) {
        return numerator.valueAt(x) / denominator.valueAt(x);
    }

    /**
     * Computes the derivative function of the quotient function using the quotient rule.
     *
     * @return The derivative function of the quotient function
     */
    @Override
    public Quotient derivative() {
        Function numeratorDerivative = numerator.derivative();
        Function denominatorDerivative = denominator.derivative();
        numeratorDerivative = new Difference(new Product(numeratorDerivative, denominator),
                                             new Product(denominatorDerivative, numerator));

        return new Quotient(numeratorDerivative, new Power(denominator, 2));
    }

    /**
     * Returns the string representation of the quotient function.
     *
     * @return The string representation of the quotient function
     */
    @Override
    public String toString() {
        return "(" + numerator.toString() + " / " + denominator.toString() + ")";
    }
}
