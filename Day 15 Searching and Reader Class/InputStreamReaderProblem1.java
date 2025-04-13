import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderProblem1 {

    public static void main(String[] args) {

        String filepath = "C:\\Users\\hp\\Downloads\\sample_utf8.txt";
        try(InputStreamReader isr = new InputStreamReader(new FileInputStream(filepath), "UTF-8")) {
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine())  != null) {
                System.out.println(line);
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
