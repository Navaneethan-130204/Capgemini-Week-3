public class BinarySearchProblem4 {

    public static int FirstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length-1;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if(arr[mid] == target) {
                result = mid;
                right = mid - 1;
            }
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static int LastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length-1;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if(arr[mid] == target) {
                result = mid;
                left = mid + 1;
            }
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 5, 5, 5, 6};
        int target = 5;

        int first = FirstOccurrence(arr, target);
        int last = LastOccurrence(arr, target);

        if (first != -1) {
            System.out.println("First occurrence of " + target + " is at index: " + first);
            System.out.println("Last occurrence of " + target + " is at index: " + last);
        } else {
            System.out.println("Element " + target + " not found in the array.");
        }
    }
}
