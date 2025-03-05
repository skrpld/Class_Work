import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double x = 0;
        double a = 0;
        double b = 0;

        System.out.print("Enter number of the operation\n1. 3 * x + 5\n2. (a + b)/(a - b)\n3. a * x / b\nEnter number of the operation: ");
        int choise = scan.nextInt();

        switch (choise) {
            case 1:
                System.out.print("Enter x: ");
                x = scan.nextDouble();
                Calc resX = new Calc(x);
                System.out.print("Result of operation: " + resX.Calc(x));
                break;
            case 2:
                System.out.print("Enter a: ");
                a = scan.nextDouble();
                System.out.print("Enter b: ");
                b = scan.nextDouble();
                Calc resAB = new Calc(a, b);
                System.out.print("Result of operation: " + resAB.Calc(a, b));
                break;
            case 3:
                System.out.print("Enter x: ");
                x = scan.nextDouble();
                System.out.print("Enter a: ");
                a = scan.nextDouble();
                System.out.print("Enter b: ");
                b = scan.nextDouble();
                Calc resXAB = new Calc(x, a, b);
                System.out.print("Result of operation: " + resXAB.Calc(x, a, b));
                break;
            default:
                break;
        }
    }
}
class Calc {
    double result;
    double x;
    double a;
    double b;

    Calc (double x) {
        this.x = x;
    }
    Calc (double a, double b) {
        this.a = a;
        this.b = b;
    }
    Calc (double x, double a, double b) {
        this.x = x;
        this.a = a;
        this.b = b;
    }

    double Calc (double x) {
        result = 3 * x + 5;
        return result;
    }
    double Calc (double a, double b) {
        if (a == b) {
            System.out.println("ERROR: Operation is impossible")
            return null;
        result = (a + b)/(a - b);
        return result;
    }
    double Calc (double x, double a, double b) {
        if (b == 0) {
            System.out.println("ERROR: Operation is impossible")
            return null;
        result = a * x / b;
        return result;
    }
}
