import java.util.HashMap;

public class SubArraysWithZeroSum {

    public static void Sum(int[] arr) {

        HashMap<Integer, Integer> sum = new HashMap<>();
        int cumulativeSum = 0;
        sum.put(0, -1);
        for(int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];

            if(sum.containsKey(cumulativeSum)){
                int startIndex = sum.get(cumulativeSum) + 1;
                System.out.println("SubArray found from index " + startIndex + " to " + i);
            }
            sum.put(cumulativeSum,i);
        }
    }

    public static void main(String[] args) {
        int[] arr ={3, 4, -7, 1, 2, -6};
        Sum(arr);
    }
}
