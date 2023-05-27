public class Polynomial implements Function {
    private final ItemInPolynomial[] polynomial;
    public Polynomial(double... args) {
        this.polynomial = new ItemInPolynomial[args.length];
        for(int i = 0; i < args.length; i++) {
            if(args[i] != 0) {
                this.polynomial[i] = new ItemInPolynomial(args[i], i);
            }
        }
    }

    public Polynomial(ItemInPolynomial[] polynomial){
        this.polynomial = polynomial;
    }

    public ItemInPolynomial[] getPolynomial() {
        return polynomial;
    }

    @Override
    public double valueAt(double x) {
        double count = 0;
        for(int i = 0; i < this.polynomial.length; i++){
            count += this.polynomial[i].getAi() * Math.pow(x ,this.polynomial[i].getI());
        }
        return count;
    }
    @Override
    public String toString() {
        int i = 0;
        boolean flag = false;
        StringBuilder functionString = new StringBuilder();
        while (i < this.polynomial.length) {
            if (this.polynomial[i].getI() == 0) {
                functionString.append(String.valueOf(this.polynomial[i].getAi()));
                flag = true;
                i++;
                continue;
            }
            if (this.polynomial[i].getAi() > 0 && flag) {
                functionString.append('+');
            }
            if (isDoubleInt(this.polynomial[i].getAi())) {
                functionString.append(String.valueOf((int)this.polynomial[i].getAi()))
                        .append("x^").append(this.polynomial[i].getI());
                i++;
            } else {
                functionString.append(String.valueOf(this.polynomial[i].getAi()))
                        .append("x^").append(this.polynomial[i].getI());
                i++;
            }
            if (i < this.polynomial.length) {
                if (this.polynomial[i].getAi() > 0) {
                    functionString.append('+');
                }
            }
        }
        return String.valueOf(functionString);
    }
    @Override
    public Polynomial derivative() {
        boolean flag = false;
        for(int i = 0; i < this.polynomial.length || !flag; i++){
            if(this.polynomial[i].getI() == 0){
                flag = true;
            }
        }
        int temp = this.polynomial.length;
        if(flag){
            temp = this.polynomial.length - 1;
        }
        ItemInPolynomial[] derivativePolynomial = new ItemInPolynomial[temp];
        int i = 0;
        if(flag){
            i = 1;
        }
        for(; i < temp; i++ ){
            derivativePolynomial[i] = new ItemInPolynomial(polynomial[i].getAi()* polynomial[i].getI()
                    , polynomial[i].getI() - 1 );
        }
        return  new Polynomial(derivativePolynomial);
    }

    @Override
    public double bisectionMethod(double a, double b, double epsilon) {
        double left = a;
        double right = b;
        double mid;
        while(right - left > epsilon){
            mid = (left + right) / 2;
            if( valueAt(left) * valueAt(mid) > 0){
                left = mid;
            } else {
                right = mid;
            }
        }
        return ((left + right) / 2);
    }

    @Override
    public double bisectionMethod(double a, double b) {
        return bisectionMethod(a, b ,Math.pow(10, -5));
    }

    @Override
    public double newtonRaphsonMethod(double a, double epsilon) {
        while (!(Math.abs(this.valueAt(a)) < epsilon)){
            a = Withdrawal(a);
        }
        return a;
    }

    @Override
    public double newtonRaphsonMethod(double a) {
        return newtonRaphsonMethod(a , Math.pow(10, -5));
    }

    @Override
    public Polynomial taylorPolynomial(int n) {
        int i = 0;
        ItemInPolynomial[] temp = new ItemInPolynomial[this.polynomial.length];
        while (this.polynomial[i].getI() <= n){
            temp[i] = this.polynomial[i];
            i++;
        }
        ItemInPolynomial[] taylorPoly = new ItemInPolynomial[i];
        for(int j = 0; j < i; j++){
            taylorPoly[j] = temp[j];
        }
        return new Polynomial(taylorPoly);
    }
    public boolean isDoubleInt(double d) {
        //select a "tolerance range" for being an integer
        double TOLERANCE = 1E-5;
        //do not use (int)d, due to weird floating point conversions!
        return Math.abs(Math.floor(d) - d) < TOLERANCE;
    }
    public double Withdrawal(double Xk){
        double fxk = this.valueAt(Xk);
        double dfxk = this.derivative().valueAt(Xk);
        return Xk - (fxk / dfxk);
    }
}
