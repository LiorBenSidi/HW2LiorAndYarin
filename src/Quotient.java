public class Quotient implements Function {
    private final Function f;
    private final Function g;
    public Quotient(Function f, Function g) {
        this.f = f;
        this.g = g;
    }

    @Override
    public double valueAt(double x) {
        if(!(this.f instanceof Quotient) && !(this.g instanceof Quotient)) {
            return f.valueAt(x) + g.valueAt(x);
        } else {
            boolean isPoly = false;
            while (this.f instanceof Quotient && this.g instanceof Quotient && !isPoly) {
                
            }
        }
        return
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
