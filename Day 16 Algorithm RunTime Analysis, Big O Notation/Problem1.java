import java.util.Arrays;
import java.util.Random;

public class Problem1 {

    public static int LinearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int BinarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] datasetSizes = {1000, 10000, 1000000};

        Random rand = new Random();
        int target = rand.nextInt(1000000);

        for (int size : datasetSizes) {
            int[] arr = new int[size];

            for (int i = 0; i < size; i++) {
                arr[i] = rand.nextInt(1000000);
            }

            long startTime = System.nanoTime();
            LinearSearch(arr, target);
            long endTime = System.nanoTime();
            System.out.println("Linear Search time for size " + size + ": " + (endTime - startTime) / 1000000.0 + " ms");

            Arrays.sort(arr);

            startTime = System.nanoTime();
            BinarySearch(arr, target);
            endTime = System.nanoTime();
            System.out.println("Binary Search time for size " + size + ": " + (endTime - startTime) / 1000000.0 + " ms");
        }
    }
}
