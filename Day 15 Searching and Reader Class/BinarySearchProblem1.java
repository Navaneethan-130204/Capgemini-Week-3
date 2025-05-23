public class BinarySearchProblem1 {

    public static int BinarySearch(int[] arr) {
        int left = 0, right = arr.length-1;

        while (left < right) {
             int mid = (left + right) / 2 ;

             if(arr[mid] > arr[right]) {
                 left = mid+1;
             }
             else {
                 right = mid;
             }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = { 15, 18, 2, 3, 6, 12 };
        int rotationPoint = BinarySearch(arr);

        System.out.println("Rotation point is at index: " + rotationPoint);
        System.out.println("Smallest element is: " + arr[rotationPoint]);
    }
}
