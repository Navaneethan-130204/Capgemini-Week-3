import java.util.HashMap;
import java.util.HashSet;

public class PairSum {

    public static void pairSum(int[] arr, int target) {

        HashMap<Integer, Integer> pairs = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];

            if(pairs.containsKey(complement)) {
                System.out.println("Pair Exist!");
                System.out.println("The pair is " + complement + " and " + arr[i]);
            }
            pairs.put(arr[i],complement);
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 1, 6, 2};
        int target = 10;
        pairSum(arr, target);
    }
}
