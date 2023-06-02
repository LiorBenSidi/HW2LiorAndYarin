public class MultiProduct extends Function {
    private final Function[] functions;

    public MultiProduct(Function f, Function g, Function... args) {
        Function[] factors = new Function[args.length + 2];
        factors[0] = f;
        factors[1] = g;
        for(int i = 2; i < args.length + 2; i++) {
            factors[i] = args[i-2];
        }
        this.functions = factors;
    }

    private MultiProduct(Function derivative, Function[] otherFunctions) {
        Function[] factors = new Function[otherFunctions.length + 1];
        factors[0] = derivative;
        for(int i = 1; i < otherFunctions.length + 1; i++) {
            factors[i] = otherFunctions[i-1];
        }
        this.functions = factors;
    }

    @Override
    public double valueAt(double x) {
        double result = 1.0;
        for (Function factor : functions) {
            result *= factor.valueAt(x);
        }

        return result;
    }

    @Override
    public Function derivative() {
        int numOfFunctions = functions.length;
        Function[] derivatives = new Function[numOfFunctions];
        for (int i = 0; i < numOfFunctions; i++) {
            int k = 0;
            Function[] otherFunctions = new Function[numOfFunctions - 1];
            for(int j = 0; j < numOfFunctions; j++) {
                if (i != j) {
                    otherFunctions[k++] = functions[j];
                }
            }
            derivatives[i] = new MultiProduct(functions[i].derivative(),otherFunctions);
        }

        return splitDerivative(derivatives);
    }

    public MultiSum splitDerivative(Function[] derivatives) {
        return MultiSum.getMultiSum(derivatives, functions);
    }

    @Override
    public String toString() {
        boolean isFirstFunction = true;
        StringBuilder builder = new StringBuilder();
        for (Function function : functions) {
            if (!(isFirstFunction)) {
                builder.append(" * ").append(function.toString());
            } else {
                builder.append(function.toString());
                isFirstFunction = false;
            }
        }

        return "(" + builder + ")";
    }
}