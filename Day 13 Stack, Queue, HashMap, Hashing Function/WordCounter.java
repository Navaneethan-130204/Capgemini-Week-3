import java.util.HashSet;

class DuplicateWordChecker {

    public static void wordChecker (String sentence) {
        HashSet<String> duplicates = new HashSet<>();
        HashSet<String> unique = new HashSet<>();
        String[] words = sentence.split(" ");
        for (String str : words) {
            if(!unique.add(str)) {
                duplicates.add(str);
            }
            unique.add(str);
        }
        System.out.println("Unique words: " + unique);
        System.out.println("Duplicate words: " + duplicates);
    }

    public static void main(String[] args) {

        String text = "Java is great Java is powerful Coding in Java is fun";
        wordChecker(text);
    }
}