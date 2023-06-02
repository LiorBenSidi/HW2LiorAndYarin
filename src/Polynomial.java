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
        for(int i = 0; i < polynomial.length; i++) {
            if (polynomial[i] != null) { // Check for null terms
                double coefficient = polynomial[i].getCoefficient();
                int exponent = polynomial[i].getExponent();
                result += coefficient * Math.pow(x, exponent);
            }
        }

        return result;
    }

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
    private String formatCoefficient(double coefficient) {
        boolean isWholeNumber = coefficient == Math.floor(coefficient);
        if (!(isWholeNumber)) {
            return String.valueOf(coefficient);
        } else {
            return String.valueOf((int) coefficient);
        }
    }
}
