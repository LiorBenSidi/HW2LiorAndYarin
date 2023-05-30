public interface Function {
    double valueAt(double x);
    String toString();
    Function derivative();
    //TODO : what is the return type
    double bisectionMethod(double a, double b, double epsilon);
    double bisectionMethod(double a, double b);
    double newtonRaphsonMethod(double a, double epsilon);
    double newtonRaphsonMethod(double a);
    Polynomial taylorPolynomial(int n);

}
