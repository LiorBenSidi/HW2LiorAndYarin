public class ItemInPolynomial { // Class for each item in a polynomial {ai*x^i}
    private final double ai;
    private final int i;
    public ItemInPolynomial(double ai, int i) {
        this.ai = ai;
        this.i = i;
    }
    public double getAi() {
        return ai;
    }

    public int getI() {
        return i;
    }
    public boolean isDoubleInt(double d) {
        //select a "tolerance range" for being an integer
        double TOLERANCE = 1E-5;
        //do not use (int)d, due to weird floating point conversions!
        return Math.abs(Math.floor(d) - d) < TOLERANCE;
    }
}
