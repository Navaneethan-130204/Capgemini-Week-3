public class LinearSearchProblem1 {

    public static int linearSearch(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {51, 6, -5, -9, 62, 29, 62, 58, -31, 67, 55, -99, 25, 77, -8, -56, -30, -61, -33, -77};
        int index = linearSearch(arr);
        if(index != -1) {
            System.out.println("The first negative number is " + arr[index] + " is found at index " + index + ".");
        }
        else {
            System.out.println("Element not found.");
        }
    }
}