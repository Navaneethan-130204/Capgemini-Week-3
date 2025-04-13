import java.util.ArrayList;
import java.util.HashMap;

public class TwoSumProblem {

    public static void TwoSum(int[] arr, int target) {

        HashMap<Integer, Integer> sums = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if(sums.containsKey(complement)) {
                System.out.println("Indices: " + sums.get(complement) + " and " + i);
                System.out.println("Values: " + arr[sums.get(complement)] + " and " + arr[i]);
                System.out.println();
            }
            sums.put(arr[i], i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15, -2};
        int target = 9;

        TwoSum(arr, target);
    }
}
