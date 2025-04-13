import java.util.Stack;

public class StackSort {

    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> helperStack = new Stack<>();

    public void sortStack() {
        if(mainStack.isEmpty()) {
            System.out.println("Stack is Empty!");
            return;
        }

        while (!mainStack.isEmpty()) {
            int removed = mainStack.pop();
            while (!helperStack.isEmpty() && helperStack.peek() < removed) {
                mainStack.push(helperStack.pop());
            }
            helperStack.push(removed);
        }

        while (!helperStack.isEmpty()) {
            mainStack.push(helperStack.pop());
        }
    }

    public void display () {
        System.out.println("Stack content (top to bottom): " + mainStack);
    }

    public static void main(String[] args) {
        StackSort stackSorter = new StackSort();

        stackSorter.mainStack.push(5);
        stackSorter.mainStack.push(2);
        stackSorter.mainStack.push(9);
        stackSorter.mainStack.push(1);
        stackSorter.mainStack.push(7);

        System.out.println("Original Stack:");
        stackSorter.display();

        stackSorter.sortStack();

        System.out.println("Sorted Stack (Ascending Order):");
        stackSorter.display();
    }
}


