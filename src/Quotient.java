public class Quotient extends Function {
    private final Function f;
    private final Function g;
    private final Function[] quotientFunc;
    public Quotient(Function f, Function g) {
        this.f = f;
        this.g = g;
        this.quotientFunc = new Function[]{f,g};
    }
}
