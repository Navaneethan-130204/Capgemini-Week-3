public class Problem5 {

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] fibonacciValues = {10, 30, 50};

        for (int n : fibonacciValues) {
            System.out.println("Fibonacci for N = " + n);

            long startTime = System.currentTimeMillis();
            try {
                int recursiveResult = fibonacciRecursive(n);
                long endTime = System.currentTimeMillis();
                System.out.println("Recursive: " + recursiveResult + " Time: " + (endTime - startTime) + " ms");
            } catch (StackOverflowError e) {
                System.out.println("Recursive: Unfeasible (StackOverflowError) for N = " + n);
            }

            long startTimeIterative = System.currentTimeMillis();
            int iterativeResult = fibonacciIterative(n);
            long endTimeIterative = System.currentTimeMillis();
            System.out.println("Iterative: " + iterativeResult + " Time: " + (endTimeIterative - startTimeIterative) + " ms");

            System.out.println();
        }
    }
}
