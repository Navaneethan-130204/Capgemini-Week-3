import java.lang.reflect.Array;
import java.util.ArrayList;

public class StringBufferProblem1 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        String[] arr = {"Audi", "BMW", "Cadillac", "Volkswagen", "Hyundai", "Lamborghini", "HellCat", "Skoda"};
        for (String text : arr) {
            sb.append(text);
        }
        System.out.println(sb);
    }
}