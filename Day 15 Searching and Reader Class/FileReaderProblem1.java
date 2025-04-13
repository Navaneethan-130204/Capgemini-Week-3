import java.io.*;
public class FileReaderProblem1 {

    public static void main(String[] args) throws FileNotFoundException {
        String filepath = "C:\\Users\\hp\\Downloads\\CG JAVA Assignments\\CG_Java_Training\\src\\StringBufferProblem2.java";
        try(BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
