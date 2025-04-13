import java.util.Arrays;

public class ChallengeProblem2 {

    public static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;

        for(int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i]-1] != arr[i]) {
                int temp = arr[arr[i]-1];
                arr[arr[i]-1] = arr[i];
                arr[i] = temp;
            }
        }

        for(int i = 0; i < n; i++) {
            if(arr[i] != i+1) {
                return i+1;
            }
        }
        return n+1;
    }

    public static void Sorting(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for(int i = 0; i < n-1; i++) {
            swapped = false;
            for(int j = 0; j < n-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
    }

    public static int BinarySearch(int[] arr, int target) {
        int left = 0, right = arr.length-1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if(arr[mid] == target) {
                return mid;
            }
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1, 9, 6, 2, 7, 10, 12};
        int[] numsCopy = Arrays.copyOf(nums, nums.length);

        int missing = findFirstMissingPositive(numsCopy);
        System.out.println("First missing positive number is: " + missing);

        Sorting(nums);
        System.out.println("Sorted Array: " + Arrays.toString(nums));

        int target = 3 ;

        int index = BinarySearch(nums, target);
        if (index != -1) {
            System.out.println("Target " + target + " found at index: " + index);
        } else {
            System.out.println("Target " + target + " not found in the array.");
        }
    }
}
