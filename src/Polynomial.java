public class Polynomial implements Function {
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
                result += term.getCoefficient() * Math.pow(x, term.getExponent());
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
    public double bisectionMethod(double a, double b, double epsilon) {
        double left = a;
        double right = b;
        double mid;
        int maxIterations = 1000; // Set a maximum number of iterations

        int iterations = 0;
        while (right - left > epsilon && iterations < maxIterations) {
            mid = (left + right) / 2;
            if (valueAt(left) * valueAt(mid) > 0) {
                left = mid;
            } else {
                right = mid;
            }
            iterations++;
        }

        return (left + right) / 2;
        /*
        double left = a;
        double right = b;
        double mid;
        while (right - left > epsilon) {
            mid = (left + right) / 2;
            if (valueAt(left) * valueAt(mid) > 0) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return (left + right) / 2;
         */
    }

    @Override
    public double bisectionMethod(double a, double b) {
        return bisectionMethod(a, b, Math.pow(10, -5));
    }

    @Override
    public double newtonRaphsonMethod(double a, double epsilon) {
        while (!(Math.abs(this.valueAt(a)) < epsilon)) {
            a = withdrawal(a);
        }
        return a;
    }

    @Override
    public double newtonRaphsonMethod(double a) {
        return newtonRaphsonMethod(a, Math.pow(10, -5));
    }

    @Override
    public Polynomial taylorPolynomial(int n) {
        ItemInPolynomial[] taylorItems = new ItemInPolynomial[n + 1];
        for (int i = 0; i <= n; i++) {
            double derivative = derivative().valueAt(i);
            taylorItems[i] = new ItemInPolynomial(derivative, i);
        }
        return new Polynomial(taylorItems);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        boolean isFirstTerm = true;
        for (ItemInPolynomial term : polynomial) {
            if (term == null) {
                continue;
            }

            if(isDoubleInt(term.getCoefficient())) {
                int coefficient = (int) term.getCoefficient();
                int exponent = term.getExponent();

                if (coefficient == 0) {
                    continue;
                }

                if (!isFirstTerm && coefficient > 0) {
                    builder.append(" + ");
                }

                if (exponent == 0) {
                    builder.append(coefficient);
                } else {
                    if (coefficient != 1 && coefficient != -1) {
                        builder.append(coefficient);
                    } else if (coefficient == -1) {
                        builder.append(" - ");
                    }

                    builder.append("x");

                    if (exponent != 1) {
                        builder.append("^").append(exponent);
                    }
                }

                isFirstTerm = false;
                if (builder.length() == 0) {
                    builder.append("0");
                }
            } else {
                double coefficient = term.getCoefficient();
                int exponent = term.getExponent();

                if (coefficient == 0.0) {
                    continue;
                }

                if (!isFirstTerm && coefficient > 0.0) {
                    builder.append(" + ");
                }

                if (exponent == 0) {
                    builder.append(coefficient);
                } else {
                    if (coefficient != 1.0 && coefficient != -1.0) {
                        builder.append(coefficient);
                    } else if (coefficient == -1.0) {
                        builder.append(" - ");
                    }

                    builder.append("x");

                    if (exponent != 1) {
                        builder.append("^").append(exponent);
                    }
                }

                isFirstTerm = false;
                if (builder.length() == 0) {
                    builder.append("0");
                }
            }

        }
        return "(" + builder.toString() + ")";
    }

    private double withdrawal(double x) {
        double fx = valueAt(x);
        double dfx = derivative().valueAt(x);
        return x - (fx / dfx);
    }
    public boolean isDoubleInt(double d) {
        //select a "tolerance range" for being an integer
        double TOLERANCE = 1E-5;
        //do not use (int)d, due to weird floating point conversions!
        return Math.abs(Math.floor(d) - d) < TOLERANCE;
    }
}
