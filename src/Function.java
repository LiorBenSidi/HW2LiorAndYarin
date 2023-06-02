/**
 * The abstract base class for mathematical functions.
 * Subclasses must provide implementations for calculating the value of the function,
 * its string representation, and its derivative.
 */
abstract class Function {
    /**
     * Calculates the value of the function at the given input value.
     *
     * @param x the input value
     * @return the calculated value of the function
     */
    public abstract double valueAt(double x);

    /**
     * Returns the string representation of the function.
     *
     * @return the string representation of the function
     */
    public abstract String toString();

    /**
     * Calculates the derivative of the function.
     *
     * @return the derivative of the function
     */
    public abstract Function derivative();

    /**
     * Performs the bisection method to find the root of the function within the given interval.
     *
     * @param a       the left endpoint of the interval
     * @param b       the right endpoint of the interval
     * @param epsilon the desired accuracy of the result
     * @return the root of the function within the specified interval
     */
    public  double bisectionMethod(double a, double b, double epsilon) {
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
    }

    /**
     * Performs the bisection method to find the root of the function within the given interval
     * with a default accuracy of 10^-5.
     *
     * @param a the left endpoint of the interval
     * @param b the right endpoint of the interval
     * @return the root of the function within the specified interval
     */
    public double bisectionMethod(double a, double b) {
        return bisectionMethod(a, b, Math.pow(10, -5));
    }

    /**
     * Performs the Newton-Raphson method to find the root of the function starting from the given initial value.
     *
     * @param a the initial value
     * @param epsilon the desired accuracy of the result
     * @return the root of the function
     */
    public double newtonRaphsonMethod(double a, double epsilon) {
        while (!(Math.abs(this.valueAt(a)) < epsilon)) {
            double fx = valueAt(a);
            double dfx = derivative().valueAt(a);
            a = a - (fx / dfx);
        }

        return a;
    }

    /**
     * Performs the Newton-Raphson method to find the root of the function starting from the given initial value
     * with a default accuracy of 10^-5.
     *
     * @param a the initial value
     * @return the root of the function
     */
    public double newtonRaphsonMethod(double a) {
        return newtonRaphsonMethod(a, Math.pow(10, -5));
    }

    /**
     * Calculates the Taylor polynomial of the function up to the specified degree.
     *
     * @param n the degree of the Taylor polynomial
     * @return the Taylor polynomial of the function
     */
    public Function taylorPolynomial(int n) {
        Function function = this;
        ItemInPolynomial[] taylorItems = new ItemInPolynomial[n + 1];
        /*
        if(function instanceof Polynomial) {
            for(int i = 0; (i < ((Polynomial) function).getPolynomial().length) && (i < n + 1); i++) {
                if(((Polynomial) function).getPolynomial()[i] != null) {
                    taylorItems[i] = new ItemInPolynomial(((Polynomial) function).getPolynomial()[i].getCoefficient(),i);

                }
            }
            return new Polynomial(taylorItems);
        }
         */
        taylorItems[0] = new ItemInPolynomial(valueAt(0), 0);
        if (taylorItems.length > 1) {
            for (int i = 1; i < n + 1; i++) {
                function =  function.derivative();
                double count = 1.0;
                double derivative = function.valueAt(0);
                for (int j = 1; j <= i; j++) {
                    count *= j;
                }
                double dc = derivative / count;
                taylorItems[i] = new ItemInPolynomial(dc, i);
            }
        }

        return new Polynomial(taylorItems);
    }
}
