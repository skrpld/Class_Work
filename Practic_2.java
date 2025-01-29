import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите x:");
        double x = scan.nextDouble();
        System.out.println("Введите n:");
        double n = scan.nextDouble();
        double res = 0;

        for (double i = 0; i <= n; i++) {
            res += Math.pow(-1, i + 1) / ((2 * i + 1) * Math.pow(x, 2 * i + 1));
        }

        res -= Math.PI / 2;
        System.out.printf("Результат функции = %f", res);
    }
}