public class MultiSum implements Function {
    private final Function[] functions;

    public MultiSum(Function... functions) {
        this.functions = functions;
    }

    @Override
    public double valueAt(double x) {
        double sum = 0;
        for (Function function : functions) {
            sum += function.valueAt(x);
        }
        return sum;
    }

    @Override
    public Function derivative() {
        Function[] derivatives = new Function[functions.length];
        for (int i = 0; i < functions.length; i++) {
            derivatives[i] = functions[i].derivative();
        }
        return new MultiSum(derivatives);
    }

    @Override
    public double bisectionMethod(double a, double b, double epsilon) {
        double fa = valueAt(a);
        double fb = valueAt(b);
        if (Math.abs(fa) < epsilon) {
            return a;
        } else if (Math.abs(fb) < epsilon) {
            return b;
        } else if (fa * fb < 0) {
            double c = (a + b) / 2;
            double fc = valueAt(c);
            if (Math.abs(fc) < epsilon) {
                return c;
            } else if (fc * fa < 0) {
                return bisectionMethod(a, c, epsilon);
            } else {
                return bisectionMethod(c, b, epsilon);
            }
        } else {
            throw new IllegalArgumentException("No root found in the given interval.");
        }
    }

    @Override
    public double bisectionMethod(double a, double b) {
        return bisectionMethod(a, b, Math.pow(10, -5));
    }

    @Override
    public double newtonRaphsonMethod(double a, double epsilon) {
        double x = a;
        double fx = valueAt(x);
        double dfx = derivative().valueAt(x);
        while (Math.abs(fx) >= epsilon) {
            x = x - fx / dfx;
            fx = valueAt(x);
            dfx = derivative().valueAt(x);
        }
        return x;
    }

    @Override
    public double newtonRaphsonMethod(double a) {
        return newtonRaphsonMethod(a, Math.pow(10, -5));
    }

    @Override
    public Polynomial taylorPolynomial(int n) {
        Polynomial p = new Polynomial(new ItemInPolynomial(0, 0));
        for (Function function : functions) {
            p = p.plus(function.taylorPolynomial(n));
        }
        return p;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i = 0; i < functions.length; i++) {
            sb.append(functions[i].toString());
            if (i != functions.length - 1) {
                sb.append(" + ");
            }
        }
        sb.append(")");
        return sb.toString();
    }
}




