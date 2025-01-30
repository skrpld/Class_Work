import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Введите a: ");
        double a = scan.nextDouble();
        System.out.print("Введите b: ");
        double b = scan.nextDouble();
        double x = 0;

        System.out.printf("Значения x в диапазоне [%.0f;%.0f] которые дают целое значение формулы x^(√x):\n|", a, b);
        for (double i = a; i <= b; i++) {
            x = Math.pow(i, Math.sqrt(i));
            if (x % 1 == 0) {
                System.out.printf(" %.0f |", i);
            }
        }
    }
}