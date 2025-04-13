import java.util.HashSet;

public class StringBuilderProblem2 {
    public static String duplicates(String input) {
        StringBuilder text = new StringBuilder();
        HashSet<Character> original = new HashSet<>();

        for(int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if(!original.contains(ch)){
                text.append(ch);
                original.add(ch);
            }
        }
        return text.toString();
    }

    public static void main(String[] args) {
        String res = duplicates("Hello World");
        System.out.println(res);
    }

}
