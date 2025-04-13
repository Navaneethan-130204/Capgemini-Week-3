public class Problem3 {

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};

        for (int n : sizes) {
            System.out.println("Dataset size: " + n);

            String str = "Hello";
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < n; i++) {
                str = str + " world";
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Time taken for String concatenation: " + (endTime - startTime) + " ms");

            StringBuilder stringBuilder = new StringBuilder();
            startTime = System.currentTimeMillis();
            for (int i = 0; i < n; i++) {
                stringBuilder.append(" world");
            }
            endTime = System.currentTimeMillis();
            System.out.println("Time taken for StringBuilder concatenation: " + (endTime - startTime) + " ms");

            StringBuffer stringBuffer = new StringBuffer();
            startTime = System.currentTimeMillis();
            for (int i = 0; i < n; i++) {
                stringBuffer.append(" world");
            }
            endTime = System.currentTimeMillis();
            System.out.println("Time taken for StringBuffer concatenation: " + (endTime - startTime) + " ms");

            System.out.println();
        }
    }
}
