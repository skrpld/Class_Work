import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double x = 0;
        double n = 0;
        double res = 0;
        boolean flag = true;

        while (flag) {
            System.out.println("Введите x (x < -1):");
            x = scan.nextDouble();
            if (x < -1) {
                System.out.println("Введите n:");
                n = scan.nextDouble();
                flag = false;
                for (double i = 0; i <= n; i++) {
                    res += Math.pow(-1, i + 1) / ((2 * i + 1) * Math.pow(x, 2 * i + 1));
                }
            }
            else {
                System.out.println("Значение x не верно\n================");
            }
        }

        res -= Math.PI / 2;
        System.out.printf("Результат функции = %f", res);
    }
}