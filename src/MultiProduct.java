public class MultiProduct extends Function {
    private final Function[] multiProductOfFunc;
    public MultiProduct(Function... n) {
        this.multiProductOfFunc = new Function[n.length];
        for(int i = 0; i < n.length; i++) {
            this.multiProductOfFunc[i] = n[i];
        }
    }

    public Function[] getMultiProductOfFunc() {
        return multiProductOfFunc;
    }
}
