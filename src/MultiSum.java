public class MultiSum extends Function {
    private final Function[] multiSumOfFunc;
    public MultiSum(Function... n) {
        this.multiSumOfFunc = new Function[n.length];
        for(int i = 0; i < n.length; i++) {
            this.multiSumOfFunc[i] = n[i];
        }
    }

    public Function[] getMultiSumOfFunc() {
        return multiSumOfFunc;
    }
}
