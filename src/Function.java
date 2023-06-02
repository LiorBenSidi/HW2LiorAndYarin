abstract class Function {
    public abstract double valueAt(double x);
    public abstract String toString();
    public abstract Function derivative();
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
    public double bisectionMethod(double a, double b) {
        return bisectionMethod(a, b, Math.pow(10, -5));
    }
    public double newtonRaphsonMethod(double a, double epsilon) {
        while (!(Math.abs(this.valueAt(a)) < epsilon)) {
            double fx = valueAt(a);
            double dfx = derivative().valueAt(a);
            a = a - (fx / dfx);
        }

        return a;
    }

    public double newtonRaphsonMethod(double a) {
        return newtonRaphsonMethod(a, Math.pow(10, -5));
    }
    public Function taylorPolynomial(int n) {
        Function function = this;
        ItemInPolynomial[] taylorItems = new ItemInPolynomial[n + 1];
        if(function instanceof Polynomial) {
            for(int i = 0; (i < ((Polynomial) function).getPolynomial().length) && (i < n + 1); i++) {
                if(((Polynomial) function).getPolynomial()[i] != null) {
                    taylorItems[i] = new ItemInPolynomial(((Polynomial) function).getPolynomial()[i].getCoefficient(),i);

                }
            }
            return new Polynomial(taylorItems);
        }
        taylorItems[0] = new ItemInPolynomial(valueAt(0), 0);
        if (taylorItems.length > 1) {
            for (int i = 1; i < n + 1; i++) {
                function =  function.derivative();
                int count = 1;
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
