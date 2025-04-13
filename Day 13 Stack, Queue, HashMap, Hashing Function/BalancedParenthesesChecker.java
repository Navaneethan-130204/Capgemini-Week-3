import java.util.Stack;
public class BalancedParenthesesChecker {

    public static boolean isBalanced(String str) {
        Stack <Character> stack = new Stack<>();

        for(char ch : str.toCharArray()) {
            if(ch =='[' || ch == '{' || ch == '(') {
                stack.push(ch);
            }
            else if(ch ==']' || ch == '}' || ch == ')') {
                if(stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                if(!MatchingPair(top, ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static boolean MatchingPair(char open, char close) {
        return (open == '[' && close == ']' ||
                open == '{' && close == '}' ||
                open == '(' && close == ')');
    }

    public static void main(String[] args) {

        String stack = "{[[{()}]]}";

        if(isBalanced(stack)) {
            System.out.println("It is Balanced.");
        }
        else {
            System.out.println("It is not Balanced.");
        }
    }
}