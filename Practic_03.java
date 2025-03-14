import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] arr = {
                {5, 3, 4},
                {1, 6, 2},
                {9, 7, 8}
        };

        System.out.println("Исходный массив:");
        printArr(arr);

        for (int i = 0; i < arr.length; i++) {
            insertionSort(arr[i]);
        }

        System.out.println("\nОтсортированный массив:");
        printArr(arr);
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }
    
    public static void printArr(int[][] arr) {
        for (int[] row : arr) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}