import java.io.*;

public class Problem4 {

    public static void readWithFileReader(String fileName) throws IOException {
        long startTime = System.currentTimeMillis();
        try (FileReader fileReader = new FileReader(fileName)) {
            int character;
            while ((character = fileReader.read()) != -1) {
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("FileReader Time for " + fileName + ": " + (endTime - startTime) + " ms");
    }

    public static void readWithInputStreamReader(String fileName) throws IOException {
        long startTime = System.currentTimeMillis();
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(fileName))) {
            int character;
            while ((character = inputStreamReader.read()) != -1) {
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("InputStreamReader Time for " + fileName + ": " + (endTime - startTime) + " ms");
    }

    public static void main(String[] args) {
        String[] fileNames = {
                "C:\\Users\\hp\\Downloads\\sample.txt",
                "C:\\Users\\hp\\Downloads\\Linear_Search_Text.txt",
                "C:\\Users\\hp\\Downloads\\largefile.txt"
        };

        for (String fileName : fileNames) {
            try {
                System.out.println("Reading file: " + fileName);

                readWithFileReader(fileName);

                readWithInputStreamReader(fileName);

                System.out.println();
            } catch (IOException e) {
                System.err.println("Error reading file: " + fileName);
                e.printStackTrace();
            }
        }
    }
}
