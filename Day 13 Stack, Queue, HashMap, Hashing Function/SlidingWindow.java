import java.util.*;

public class SlidingWindow {

    public static void SlidingWindows(int[] values, int k) {

        Deque<Integer> deque = new LinkedList<>();

        for(int i = 0; i < values.length; i++) {

            if(!deque.isEmpty() && deque.peekFirst() <= i-k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && values[deque.peekLast()] < values[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if(i >= k-1) {
                System.out.print(values[deque.peekFirst()] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] values = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.print("Sliding Window Maximum: ");
        SlidingWindows(values, k);
    }
}