/**
 * A class that represents a function that is the product of multiple functions.
 * Inherits from the Function abstract class.
 */
public class MultiProduct extends Function {
    private final Function[] functions;

    /**
     * Constructs a MultiProduct object with the given functions.
     * The product is computed as f * g * args[0] * args[1] * ...
     *
     * @param f The first function
     * @param g The second function
     * @param args Additional functions
     */
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

    /**
     * Computes the value of the MultiProduct at a given value.
     *
     * @param x The given value
     * @return The result of evaluating the MultiProduct at the input value
     */
    @Override
    public double valueAt(double x) {
        double result = 1.0;
        for(Function factor : functions) {
            result *= factor.valueAt(x);
        }

        return result;
    }

    /**
     * Computes the derivative function of the MultiProduct according to the required requirements.
     *
     * @return The derivative function of the MultiProduct
     */
    @Override
    public MultiSum derivative() {
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


    /**
     * Splits the derivatives of the MultiProduct into a MultiSum.
     *
     * @param derivatives An array of derivative functions
     * @return A MultiSum object representing the sum of the derivatives functions
     */
    public MultiSum splitDerivative(Function[] derivatives) {
        return MultiSum.getMultiSum(derivatives, functions);
    }

    /**
     * Returns the string representation of the MultiProduct.
     *
     * @return The string representation of the MultiProduct
     */
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