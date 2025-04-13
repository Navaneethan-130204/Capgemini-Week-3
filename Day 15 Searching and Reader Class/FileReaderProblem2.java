import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderProblem2 {

    public static void main(String[] args) {

        String filepath = "C:\\Users\\hp\\Downloads\\CG JAVA Assignments\\CG_Java_Training\\src\\StringBufferProblem2.java";

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))){

            int count = 0;
            String target = "public", line;

            while ((line = br.readLine()) != null) {
                String[] arr = line.split(" ");

                for(String word : arr) {
                    if(word.equals(target)) {
                        count++;
                    }
                }
            }
            System.out.println("The words \"" + target + "\" appears " + count + " time(s).");
        }

        catch (IOException e){
            e.printStackTrace();
        }
    }
}
