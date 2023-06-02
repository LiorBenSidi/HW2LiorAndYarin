public class MultiProduct extends Function {
    private final Function[] factors;

    public MultiProduct(Function f, Function g, Function... args) {
        Function[] factors = new Function[args.length + 2];
        factors[0] = f;
        factors[1] = g;
        for(int i = 2; i < args.length + 2; i++) {
            factors[i] = args[i-2];
        }
        this.factors = factors;
    }

    private MultiProduct(Function derivative, Function[] otherFunctions) {
        Function[] factors = new Function[otherFunctions.length + 1];
        factors[0] = derivative;
        for(int i = 1; i < otherFunctions.length + 1; i++) {
            factors[i] = otherFunctions[i-1];
        }
        this.factors = factors;
    }

    @Override
    public double valueAt(double x) {
        double result = 1.0;
        for (Function factor : factors) {
            result *= factor.valueAt(x);
        }
        return result;
    }

    @Override
    public Function derivative() {
        Function[] derivatives = new Function[factors.length];
        for (int i = 0; i < factors.length; i++) {
            Function[] otherFunctions = new Function[factors.length - 1];
            int index = 0;
            for(int j = 0; j < factors.length; j++) {
                if (j != i) {
                    otherFunctions[index++] = factors[j];
                }
            }
            derivatives[i] = new MultiProduct(factors[i].derivative(),otherFunctions);
        }
        return splitDerivative(derivatives);

    }
    public MultiSum splitDerivative(Function[] derivatives) {
        return MultiSum.getMultiSum(derivatives, factors);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        boolean isFirstFactor = true;
        for (Function factor : factors) {
            if (isFirstFactor) {
                builder.append(factor.toString());
                isFirstFactor = false;
            } else {
                builder.append(" * ").append(factor.toString());
            }
        }
        return "(" + builder + ")";
    }
}