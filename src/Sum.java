public class Sum extends Function {
    private final Function f;
    private final Function g;
    private final Function[] sumOfFunc;

    public Sum(Function f, Function g) {
        this.f = f;
        this.g = g;
        this.sumOfFunc = new Function[]{f,g};
    }

    public Function[] getSumOfFunc() {
        return sumOfFunc;
    }
}
