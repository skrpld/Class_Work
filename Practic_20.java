public class Main {
    public static void main(String[] args) {
        Calculator calculator = Calculator.getInstance();

        double result = calculator.calculate(5, 2);
        System.out.println(calculator);
    }
}

class Calculator {
    private static Calculator instance;

    private Calculator() {
    }

    public static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        }
        return instance;
    }

    public double calculate(double x, double y) {
        if (y == 0) {
            throw new ArithmeticException("Division by zero: y cannot be zero");
        }
        return (2 * x) + (3 / y);
    }
}