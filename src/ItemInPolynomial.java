/**
 * A class representing an item in a polynomial.
 */
public class ItemInPolynomial {
    private final double coefficient;
    private final int exponent;

    /**
     * Constructs an ItemInPolynomial object with the specified coefficient and exponent.
     *
     * @param coefficient the coefficient of the item
     * @param exponent the exponent of the item
     */
    public ItemInPolynomial(double coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = Math.abs(exponent);
    }

    /**
     * Returns the coefficient of the item.
     *
     * @return the coefficient
     */
    public double getCoefficient() {
        return coefficient;
    }

    /**
     * Returns the exponent of the item.
     *
     * @return the exponent
     */
    public int getExponent() {
        return exponent;
    }
}