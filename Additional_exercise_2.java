import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Введите x: ");
        int x = scan.nextInt();
        int step = 0;

        while (x != 1) {
            if (x % 2 == 0) {
                x /= 2;
            }
            else {
                x = x * 3 + 1;
            }
            step++;
        }

        System.out.printf("для преобразования x в 1 потребовалось %d шагов", step);
    }
}