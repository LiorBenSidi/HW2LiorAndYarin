public class Polynomial extends Function {
    private final ItemInPolynomial[] polynomial;
    public Polynomial(double... n) {
        this.polynomial = new ItemInPolynomial[n.length];
        int i = n.length;
        int j = 0;
        while(j < n.length) {
            if(n[j] != 0) {
                this.polynomial[j] = new ItemInPolynomial(n[j], i);
            }
            i--;
            j++;
        }
    }

    public ItemInPolynomial[] getPolynomial() {
        return polynomial;
    }
}
