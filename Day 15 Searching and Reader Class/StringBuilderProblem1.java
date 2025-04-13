public class StringBuilderProblem1 {

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder();
        text.append("Hello World!");
        text.reverse();
        text.toString();
        System.out.println(text);
    }
}