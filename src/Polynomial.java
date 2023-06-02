/**
 * A class representing a polynomial function.
 */
public class Polynomial extends Function {
    private final ItemInPolynomial[] polynomial;

    /**
     * Constructs a Polynomial object with the specified coefficients.
     * The coefficients are provided as a variable number of arguments in decreasing order of exponents.
     *
     * @param args the coefficients of the polynomial in decreasing order of exponents
     */
    public Polynomial(double... args) {
        this.polynomial = new ItemInPolynomial[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i] != 0) {
                this.polynomial[i] = new ItemInPolynomial(args[i], i);
            } else {
                this.polynomial[i] = null; // Initialize unused terms as null
            }
        }
    }

    /**
     * Constructs a Polynomial object with the specified polynomial items.
     *
     * @param polynomial the array of ItemInPolynomial objects representing the polynomial items
     */
    public Polynomial(ItemInPolynomial[] polynomial) {
        this.polynomial = polynomial;
    }

    /**
     * Returns the polynomial array.
     *
     * @return the polynomial array
     */
    public ItemInPolynomial[] getPolynomial() {
        return polynomial;
    }

    /**
     * Evaluates the polynomial function at the specified value of x.
     *
     * @param x the value of x
     * @return the result of evaluating the polynomial at x
     */
    @Override
    public double valueAt(double x) {
        double result = 0.0;
        for(int i = 0; i < polynomial.length; i++) {
            if (polynomial[i] != null) { // Check for null terms
                double coefficient = polynomial[i].getCoefficient();
                int exponent = polynomial[i].getExponent();
                result += coefficient * Math.pow(x, exponent);
            }
        }

        return result;
    }

    /**
     * Computes the derivative of the polynomial function.
     *
     * @return the derivative of the polynomial as a new Polynomial object
     */
    @Override
    public Function derivative() {
        ItemInPolynomial[] derivativePolynomial = new ItemInPolynomial[polynomial.length];
        for (int i = 0; i < polynomial.length; i++) {
            if (polynomial[i] != null) {
                double coefficient = polynomial[i].getCoefficient() * polynomial[i].getExponent();
                int exponent = polynomial[i].getExponent() - 1;
                derivativePolynomial[i] = new ItemInPolynomial(coefficient, exponent);
            }
        }

        return new Polynomial(derivativePolynomial);
    }

    /**
     * Returns a string representation of the polynomial.
     *
     * @return a string representation of the polynomial
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        boolean isFirstItem = false;
        int i = 0;
        while (i < polynomial.length) {
            if (polynomial[i] == null) {
                i++;
            } else {
                double coefficient = polynomial[i].getCoefficient();
                int exponent = polynomial[i].getExponent();
                if (coefficient == 0.0) {
                    i++;
                } else {
                    if (isFirstItem && coefficient > 0.0) {
                        builder.append(" + ");
                    }
                    if (coefficient < 0.0 && exponent != 0) {
                        builder.append(" - ");
                        coefficient = Math.abs(coefficient);
                    }
                    if (exponent == 0) {
                        builder.append(formatCoefficient(coefficient));
                    } else {
                        if (coefficient != 1.0) {
                            builder.append(formatCoefficient(coefficient));
                        }
                        builder.append("x");
                        if (exponent != 1) {
                            builder.append("^").append(exponent);
                        }
                    }
                    isFirstItem = true;
                    i++;
                }
            }
        }
        if (builder.length() == 0) {
            builder.append("0");
        }

        return "(" + builder + ")";
    }

    /**
     * Formats the coefficient value as a string.
     *
     * @param coefficient the coefficient value
     * @return the formatted coefficient as a string
     */
    private String formatCoefficient(double coefficient) {
        boolean isWholeNumber = coefficient == Math.floor(coefficient);
        if (!(isWholeNumber)) {
            return String.valueOf(coefficient);
        } else {
            return String.valueOf((int) coefficient);
        }
    }
}
