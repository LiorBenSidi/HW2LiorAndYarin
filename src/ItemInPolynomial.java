public class ItemInPolynomial {

    private int coefficientInt;
    private double coefficient;
    private final int exponent;

    public ItemInPolynomial(double coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }
    public ItemInPolynomial(int coefficientInt, int exponent) {
        this.coefficientInt = coefficientInt;
        this.exponent = exponent;
    }
    public double getCoefficient() {
        return coefficient;
    }
    //TODO: Add condition to each get of coefficient/coefficientInt
    public int getCoefficientInt() {
        return coefficientInt;
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

    public void setCoefficient(double v) {
        this.coefficient = v;
    }
}