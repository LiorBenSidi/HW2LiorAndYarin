public class Polynomial extends Function {
    private final ItemInPolynomial[] polynomial;

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

    public Polynomial(ItemInPolynomial[] polynomial) {
        this.polynomial = polynomial;
    }

    public ItemInPolynomial[] getPolynomial() {
        return polynomial;
    }

    @Override
    public double valueAt(double x) {
        double result = 0.0;
        for (ItemInPolynomial term : polynomial) {
            if (term != null) { // Check for null terms
                double coefficient = term.getCoefficient();
                int exponent = term.getExponent();
                result += coefficient * Math.pow(x, exponent);
            }
        }
        return result;
    }

    @Override
    public Function derivative() {
        ItemInPolynomial[] derivativePolynomial = new ItemInPolynomial[polynomial.length];
        for (int i = 0; i < polynomial.length; i++) {
            ItemInPolynomial term = polynomial[i];
            if (term != null) {
                double coefficient = term.getCoefficient() * term.getExponent();
                int exponent = term.getExponent() - 1;
                derivativePolynomial[i] = new ItemInPolynomial(coefficient, exponent);
            }
        }
        return new Polynomial(derivativePolynomial);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        boolean isFirstTerm = true;

        for (ItemInPolynomial term : polynomial) {
            if (term == null) {
                continue;
            }

            double coefficient = term.getCoefficient();
            int exponent = term.getExponent();

            if (coefficient == 0.0) {
                continue;
            }

            if (!isFirstTerm && coefficient > 0.0) {
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

            isFirstTerm = false;
        }

        if (builder.length() == 0) {
            builder.append("0");
        }

        return "(" + builder + ")";
    }
    private String formatCoefficient(double coefficient) {
        if (isWholeNumber(coefficient)) {
            return String.valueOf((int) coefficient);
        } else {
            return String.valueOf(coefficient);
        }
    }
    private boolean isWholeNumber(double number) {
        return number == Math.floor(number);
    }
}
