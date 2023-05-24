public class Difference extends Function {
    private final Function f;
    private final Function g;
    private final Function[] diffOfFunc;
    public Difference(Function f, Function g) {
        this.f = f;
        this.g = g;
        this.diffOfFunc = new Function[]{f,g};
    }

    public Function[] getDiffOfFunc() {
        return diffOfFunc;
    }
}
