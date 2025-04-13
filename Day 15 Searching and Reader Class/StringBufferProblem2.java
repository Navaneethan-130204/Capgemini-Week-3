public class StringBufferProblem2 {

    public static long StringBuilderPerformance() {
        StringBuilder sb = new StringBuilder();
        long start = System.nanoTime();
        for(int i = 0; i < 1000000; i++) {
            sb.append("Hello");
        }
        long end = System.nanoTime();
        return end - start;
    }

    public static long StringBufferPerformance() {
        StringBuffer sb = new StringBuffer();
        long start = System.nanoTime();
        for(int i = 0; i < 1000000; i++) {
            sb.append("Hello");
        }
        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String[] args) {
        System.out.println("StringBuilder Time: " + StringBuilderPerformance());
        System.out.println("StringBuffer Time: " + StringBufferPerformance());
    }
}
