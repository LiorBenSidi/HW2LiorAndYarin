public class MultiSum extends Function {
    private final Function[] functions;

    public MultiSum(Function f, Function g, Function... args) {
        Function[] factors = new Function[args.length + 2];
        factors[0] = f;
        factors[1] = g;
        for(int i = 2; i < args.length + 2; i++) {
            factors[i] = args[i-2];
        }
        this.functions = factors;
    }

    @Override
    public double valueAt(double x) {
        double sum = 0.0;
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
        return splitDerivative(derivatives);
    }
    public MultiSum splitDerivative(Function[] derivatives) {
        return getMultiSum(derivatives, functions);
    }

    static MultiSum getMultiSum(Function[] derivatives, Function[] functions) {
        Function derivativesFirst;
        Function derivativesSecond;
        derivativesFirst = derivatives[0];
        derivativesSecond = derivatives[1];
        Function[] derivativesOthers = new Function[functions.length - 2];
        for(int i = 0; i < functions.length - 2; i++) {
            derivativesOthers[i] = derivatives[i + 2];
        }
        return new MultiSum(derivativesFirst, derivativesSecond, derivativesOthers);
    }

    @Override
    public double newtonRaphsonMethod(double a, double epsilon) {
        while (!(Math.abs(this.valueAt(a)) < epsilon)) {
            a = withdrawal(a);
        }
        return a;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i = 0; i < functions.length; i++) {
            sb.append(functions[i].toString());
            if (i < functions.length - 1) {
                sb.append(" + ");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    private double withdrawal(double x) {
        double fx = valueAt(x);
        double dfx = derivative().valueAt(x);
        return x - (fx / dfx);
    }
}