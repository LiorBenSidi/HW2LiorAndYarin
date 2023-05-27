public class Sum implements Function {
    private final Function f;
    private final Function g;

    public Sum(Function f, Function g) {
        this.f = f;
        this.g = g;
    }

    @Override
    public double valueAt(double x) {
        /* Sum of 2 polynomials. */
        if(f instanceof Polynomial && g instanceof Polynomial) {
            return f
        }

    }

    @Override
    public Function derivative() {
        return ;
    }

    @Override
    public double bisectionMethod(double a, double b, double epsilon) {
        double left = a;
        double right = b;
        double mid;
        while(right - left > epsilon){
            mid = (left + right) / 2;
            if( this.valueAt(left) * this.valueAt(mid) > 0){
                left = mid;
            } else {
                right = mid;
            }
        }
        return ((left + right) / 2);
    }

    @Override
    public double bisectionMethod(double a, double b) {
        return bisectionMethod(a, b ,Math.pow(10, -5));
    }

    @Override
    public double newtonRaphsonMethod(double a, double epsilon) {
        while (!(Math.abs(this.valueAt(a)) < epsilon)){
            a = Withdrawal(a);
        }
        return a;
    }

    @Override //Overloading?
    public double newtonRaphsonMethod(double a) {
        return newtonRaphsonMethod(a , Math.pow(10, -5));
    }

    @Override
    public Polynomial taylorPolynomial(int n) {
        return null;
    }
    public double Withdrawal(double Xk){
        double fxk = this.valueAt(Xk);
        double dfxk = this.derivative().valueAt(Xk);
        return Xk - (fxk / dfxk);
    }
}
