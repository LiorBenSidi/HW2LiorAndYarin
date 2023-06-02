public class ItemInPolynomial {
    private final double coefficient;
    private final int exponent;

    public ItemInPolynomial(double coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = Math.abs(exponent);
    }

    public double getCoefficient() {
        return coefficient;
    }

    public int getExponent() {
        return exponent;
    }
}