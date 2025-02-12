import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Введите целочисленные элементы массива через пробел:");
        String input = scan.nextLine();
        String[] inputArr = input.split(" ");
        int[] array = new int[inputArr.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(inputArr[i]);
        }

        int[] sortedArr = sort(array);
        System.out.println("Отсортированный массив:");
        for (int i = 0; i < sortedArr.length; i++) {
            System.out.print(sortedArr[i] + " ");
        }
    }
    public static int[] sort(int[] arr) {
        int a = mean(arr);
        int l = 0;
        int r = 0;
        int[] aux = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= a) {
                aux[arr.length / 2 - 1 - l] = arr[i];
                l++;
            }
            else {
                aux[arr.length / 2 - 1 + r] = arr[i];
                r++;
            }
        }

        if (arr.length > 2) {
            int[] arr1 = Arrays.copyOfRange(aux, 0, arr.length / 2);
            arr1 = sort(arr1);
            int[] arr2 = Arrays.copyOfRange(aux, arr.length / 2 - 1, arr.length - 1);
            arr2 = sort(arr2);

            for (int i = 0; i < arr.length; i++) {
                if (i < arr.length / 2) {
                    aux[i] = arr1[i];
                }
                else {
                    aux[i] = arr2[i - arr.length / 2];
                }
            }
        }

        return aux;
    }
    public static int mean(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += arr[i];
        }
        return (res / arr.length);
    }
}