import java.util.Stack;

public class CircularTourProblem {

    public static int TourProblem(int[] petrol, int[] distance) {

        int start = 0, currentSurplus = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < petrol.length; i++) {
            int netPetrol = petrol[i] - distance[i];
            currentSurplus += netPetrol;
            stack.push(netPetrol);
            if(currentSurplus < 0) {
                start = i + 1;
                stack.clear();
                currentSurplus = 0;
            }
        }
        return (!stack.isEmpty()) ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};
        System.out.println("Starting point: " + TourProblem(petrol, distance));
    }
}
