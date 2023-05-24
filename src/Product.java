public class Product extends Function {
    private final Function f;
    private final Function g;
    private final Function[] productOfFunc;
    public Product(Function f, Function g) {
        this.f = f;
        this.g = g;
        this.productOfFunc = new Function[]{f,g};
    }

    public Function[] getProductOfFunc() {
        return productOfFunc;
    }
}
