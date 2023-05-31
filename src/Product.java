public class Product implements Function {
    private final Function f;
    private final Function g;

    public Product(Function f, Function g) {
        this.f = f;
        this.g = g;
    }

    @Override
    public double valueAt(double x) {
        return f.valueAt(x) * g.valueAt(x);
    }

    @Override
    public Function derivative() {
        Function prod1 = new Product(f.derivative(), g);
        Function prod2 =new Product(g.derivative() , f);
        Function sum1 = new Sum(prod1, prod2);
        return sum1;
    }

    @Override
    public double bisectionMethod(double a, double b, double epsilon) {
        return (a + b) / 2;
    }

    @Override
    public double bisectionMethod(double a, double b) {
        return bisectionMethod(a, b, Math.pow(10, -5));
    }

    @Override
    public double newtonRaphsonMethod(double a, double epsilon) {
        while (!(Math.abs(this.valueAt(a)) < epsilon)) {
            a = withdrawal(a);
        }
        return a;
    }

    @Override
    public double newtonRaphsonMethod(double a) {
        return newtonRaphsonMethod(a, Math.pow(10, -5));
    }

    @Override
    public Polynomial taylorPolynomial(int n) {
        //return new Polynomial(new ItemInPolynomial[]{new ItemInPolynomial(0.0, 0)});
        Polynomial fTaylor = f.taylorPolynomial(n);
        Polynomial gTaylor = g.taylorPolynomial(n);

        ItemInPolynomial[] productTerms = new ItemInPolynomial[(n + 1) * (n + 1)];
        int index = 0;

        for (ItemInPolynomial termF : fTaylor.getPolynomial()) {
            for (ItemInPolynomial termG : gTaylor.getPolynomial()) {
                double coefficient = termF.getCoefficient() * termG.getCoefficient();
                int exponent = termF.getExponent() + termG.getExponent();
                productTerms[index] = new ItemInPolynomial(coefficient, exponent);
                index++;
            }
        }

        return new Polynomial(productTerms);
    }

    @Override
    public String toString() {
        return "(" + f.toString() + " * " + g.toString() + ")";
    }

    private double withdrawal(double x) {
        double fx = valueAt(x);
        double dfx = derivative().valueAt(x);
        return x - (fx / dfx);
    }
}