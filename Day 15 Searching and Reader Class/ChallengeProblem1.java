import java.io.*;

public class ChallengeProblem1 {

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

    public static void FileReaderPerformance(String filepath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            long start = System.nanoTime();
            int count = 0;
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(" ");
                for (String text : arr) {
                    count++;
                }
            }
            long end = System.nanoTime();
            System.out.println("Word Count : " + count + " -> FileReader Time: " + (end - start));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void InputStreamReaderPerformance (String filepath) {
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filepath))) {
            BufferedReader br = new BufferedReader(isr);
            long start = System.nanoTime();
            int count = 0;
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(" ");
                for (String text : arr) {
                    count++;
                }
            }
            long end = System.nanoTime();
            System.out.println("Word Count : " + count + " -> InputStreamReader Time: " + (end - start));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String filePath = "C:\\Users\\hp\\Downloads\\largefile.txt";  // should be a text file (not a docx!)

        System.out.println("StringBuilder Time: " + StringBuilderPerformance() + " ns");
        System.out.println("StringBuffer Time: " + StringBufferPerformance() + " ns");

        FileReaderPerformance(filePath);
        InputStreamReaderPerformance(filePath);
    }
}
