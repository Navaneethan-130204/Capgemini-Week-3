public class LinearSearchProblem2 {

    public static String LinearSearch(String[] sentence, String word) {
        for(String text : sentence) {
            if(text.contains(word)) {
                return text;
            }
        }
        return "Not Found!";
    }

    public static void main(String[] args) {

        String[] sentences = {
                "Java is a powerful language.",
                "Python is good for beginners.",
                "C++ is fast and efficient."
        };
        String word = "Python";
        System.out.println("Search Result: " + LinearSearch(sentences, word));
    }
}
