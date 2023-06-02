public class Product extends Function {
    private final Function f, g;

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
        return new Sum(new Product(f.derivative(), g), new Product(g.derivative() , f));
    }

    @Override
    public String toString() {
        return "(" + f.toString() + " * " + g.toString() + ")";
    }
}