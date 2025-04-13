import java.util.Stack;

public class StockSpan {

    public static void findSpan(int[] price, int n , int[] span) {

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        span[0] = 1;

        for(int i = 0; i < n; i++) {
            while (!stack.empty() && price[stack.peek()] <= price[i]) {
                stack.pop();
            }

            span[i] = (stack.isEmpty()) ? (i+1) : (i - stack.peek());

            stack.push(i);
        }
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int n = prices.length;
        int[] span = new int[n];

        findSpan(prices, n, span);

        System.out.println("Stock Prices:");
        for (int price : prices) {
            System.out.print(price + " ");
        }
        System.out.println();

        System.out.println("Span Values:");
        for (int s : span) {
            System.out.print(s + " ");
        }
    }
}


