public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {5, 3, 8, 4, 2},
                {9, 1, 7, 6, 0},
                {4, 2, 5, 8, 3}
        };

        for (int[] row : matrix) {
            Sort(row);
        }

        System.out.println("\nОтсортированный массив:");
        output(matrix);
    }

    public static void Sort(int[] arr) {
        int interval = arr.length;
        boolean swap;
        final double SHRINK_FACTOR = 1.3;

        do {
            interval = (int)(interval / SHRINK_FACTOR);
            if (interval < 1) { interval = 1;}

            swap = false;
            for (int i = 0; i + interval < arr.length; i++) {
                if (arr[i] > arr[i + interval]) {
                    int temp = arr[i];
                    arr[i] = arr[i + interval];
                    arr[i + interval] = temp;
                    swap = true;
                }
            }
        } while (interval > 1 || swap);
    }

    public static void output(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
