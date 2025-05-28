import java.util.Arrays;

interface Sorter {
    boolean apply(int a, int b);
}

public class Main {
    public static void main(String[] args) {
        int[] nums = {6, 89, 34, 100, 0, 5};
        Sorter ascendingSort = (a, b) -> a > b;
        Sorter descendingSort = (a, b) -> a < b;
        
        System.out.println(Arrays.toString(sort(nums, ascendingSort)));
        System.out.println(Arrays.toString(sort(nums.clone(), descendingSort)));
    }

    public static int[] sort(int[] nums, Sorter sorter) {
        int len = nums.length;
        int temp;
        boolean swap;

        for (int i = 0; i < len - 1; i++) {
            swap = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (sorter.apply(nums[j], nums[j + 1])) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swap = true;
                }
            }
            if (!swap) break;
        }
        return nums;
    }
}