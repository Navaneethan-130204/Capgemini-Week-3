import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderProblem2 {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\hp\\Downloads\\user_input.txt";

        try(InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            FileWriter fr = new FileWriter(filePath)) {

            System.out.println("Enter text (type 'exit' to finish):");

            String line;
            while (true) {
                line = br.readLine();

                if(line.equalsIgnoreCase("exit")) {
                    break;
                }

                fr.write(line + "\n");
            }
            System.out.println("User input successfully written to file!");

        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
