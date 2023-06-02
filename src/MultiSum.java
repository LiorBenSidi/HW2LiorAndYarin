/**
 * A class that represents a function that is the sum of multiple functions.
 * Inherits from the Function abstract class.
 */
public class MultiSum extends Function {
    private final Function[] functions;

    /**
     * Constructs a MultiSum object with the given functions.
     * The sum is computed as f + g + args[0] + args[1] + ...
     *
     * @param f The first function
     * @param g The second function
     * @param args Additional functions
     */
    public MultiSum(Function f, Function g, Function... args) {
        Function[] factors = new Function[args.length + 2];
        factors[0] = f;
        factors[1] = g;
        for(int i = 2; i < args.length + 2; i++) {
            factors[i] = args[i-2];
        }

        this.functions = factors;
    }

    /**
     * Computes the value of the MultiSum at a given value.
     *
     * @param x The given value
     * @return The result of evaluating the MultiSum according the given value
     */
    @Override
    public double valueAt(double x) {
        double sum = 0.0;
        for (Function function : functions) {
            sum += function.valueAt(x);
        }

        return sum;
    }

    /**
     * Computes the derivative function of the MultiSum.
     *
     * @return The derivative function of the MultiSum
     */
    @Override
    public MultiSum derivative() {
        Function[] derivatives = new Function[functions.length];
        for(int i = 0; i < functions.length; i++) {
            derivatives[i] = functions[i].derivative();
        }
        return splitDerivative(derivatives);
    }

    /**
     * Splits the derivatives of the MultiSum into a new MultiSum object.
     *
     * @param derivatives The array of derivative functions
     * @return A new MultiSum object representing the sum of the derivatives of given array of derivative functions
     */
    public MultiSum splitDerivative(Function[] derivatives) {
        return getMultiSum(derivatives, functions);
    }

    /**
     * Creates a new MultiSum object from the given derivative functions and original functions.
     *
     * @param derivatives The derivative functions
     * @param functions The original functions
     * @return A new MultiSum object that gets the derivatives
     */
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

    /**
     * Returns the string representation of the MultiSum.
     *
     * @return The string representation of the MultiSum
     */
    @Override
    public String toString() {
        int numOfFunctions = functions.length;
        StringBuilder builder = new StringBuilder();
        builder.append("(");
        for (int i = 0; i < numOfFunctions; i++) {
            builder.append(functions[i].toString());
            if (i < numOfFunctions - 1) {
                builder.append(" + ");
            }
        }

        builder.append(")");
        return builder.toString();
    }
}