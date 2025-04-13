import java.util.*;

public class Problem6 {

    public static void main(String[] args) {
        int[] sizes = {1000, 100000, 1000000};
        int target = 999999;

        for (int n : sizes) {
            System.out.println("Dataset Size: " + n);

            int[] array = new int[n];
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();

            for (int i = 0; i < n; i++) {
                array[i] = i;
                hashSet.add(i);
                treeSet.add(i);
            }

            long startTimeArray = System.currentTimeMillis();
            boolean foundArray = false;
            for (int num : array) {
                if (num == target) {
                    foundArray = true;
                    break;
                }
            }
            long endTimeArray = System.currentTimeMillis();
            System.out.println("Array Search: " + (endTimeArray - startTimeArray) + " ms");

            long startTimeHash = System.currentTimeMillis();
            boolean foundHash = hashSet.contains(target);
            long endTimeHash = System.currentTimeMillis();
            System.out.println("HashSet Search: " + (endTimeHash - startTimeHash) + " ms");

            long startTimeTree = System.currentTimeMillis();
            boolean foundTree = treeSet.contains(target);
            long endTimeTree = System.currentTimeMillis();
            System.out.println("TreeSet Search: " + (endTimeTree - startTimeTree) + " ms");

            System.out.println();
        }
    }
}
