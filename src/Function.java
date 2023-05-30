public interface Function {
    double valueAt(double x);
    Function derivative();
    double bisectionMethod(double a, double b, double epsilon);
    double bisectionMethod(double a, double b);
    double newtonRaphsonMethod(double a, double epsilon);
    double newtonRaphsonMethod(double a);
    Polynomial taylorPolynomial(int n);
    String toString();
}