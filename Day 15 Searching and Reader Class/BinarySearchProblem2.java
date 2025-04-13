public class BinarySearchProblem2 {

    public static int BinarySearch(int[] arr) {
        int left = 0, right = arr.length-1;
        int mid = (left + right) / 2;
        while (left <= right) {
            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) {
                return mid;
            }
            else if(arr[mid] < arr[mid-1]) {
                right = mid - 1;
            }
            else if (arr[mid] < arr[mid+1]){
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {5, 10, 20, 15, 7, 9, 25, 30, 12, 6, 11, 40, 35, 2, 1};
        int peakIndex = BinarySearch(arr);
        if (peakIndex != -1) {
            System.out.println("Peak element found at index " + peakIndex + ": " + arr[peakIndex]);
        } else {
            System.out.println("No peak element found.");
        }
    }
}