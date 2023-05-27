public class Product extends Function {
    private final Function f;
    private final Function g;
    public Product(Function f, Function g) {
        super(f,g);
    }

    public Function[] getProductOfFunc() {
        return productOfFunc;
    }

    @Override
    public double valueAt(double x) {
        return 0;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public Function derivative() {
        return null;
    }

    @Override
    public double bisectionMethod(double a, double b, double epsilon) {
        return 0;
    }

    @Override
    public double bisectionMethod(double a, double b) {
        return 0;
    }

    @Override
    public double newtonRaphsonMethod(double a, double epsilon) {
        return 0;
    }

    @Override
    public double newtonRaphsonMethod(double a) {
        return 0;
    }

    @Override
    public Polynomial taylorPolynomial(int n) {
        return null;
    }
}
