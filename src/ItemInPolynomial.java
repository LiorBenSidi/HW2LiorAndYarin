public class ItemInPolynomial {
    private double coefficient;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (coefficient != 0) {
            if (coefficient != 1) {
                sb.append(coefficient);
            }
            if (exponent == 1) {
                sb.append("x");
            } else if (exponent > 1) {
                sb.append("x^").append(exponent);
            }
        } else {
            sb.append("0");
        }
        return sb.toString();
    }
}