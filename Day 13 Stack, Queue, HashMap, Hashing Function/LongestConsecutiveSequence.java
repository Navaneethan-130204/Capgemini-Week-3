import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static void consecutiveSequence(int[] arr) {

        HashSet<Integer> sequence = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        int maxLength = 0, current = 0, count = 0;

        for(int i : arr) {
            sequence.add(i);
        }
        for (int num : arr) {

            if(!sequence.contains(num - 1)) {
                current = num;
                count = 1;
            }

            while (sequence.contains(current + 1)){
                current++;
                count++;
                result.add(current);
            }

            if(count > maxLength) {
                maxLength = count;
            }
        }
        System.out.println("Max Length: " + maxLength);
        System.out.println(result);

    }

    public static void main(String[] args) {

        int[] arr = {5, 100, 4, 9, 8, 6, 50, 200, 7, 1, 3, 2};
        consecutiveSequence(arr);
    }
}
