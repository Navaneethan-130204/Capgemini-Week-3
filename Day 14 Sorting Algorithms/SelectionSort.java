import java.util.Arrays;

public class SelectionSort{

    public static void sortScores (int[] marks){
        int n = marks.length;

        for(int i = 0; i < n-1; i++) {
            int minIndex = i;
            for(int j = i+1; j < n; j++) {
                if(marks[minIndex] > marks[j]) {
                    minIndex = j;
                }
            }
            int temp = marks[minIndex];
            marks[minIndex] = marks[i];
            marks[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] marks = {65 ,62, 88, 25, 86 ,97, 78, 32, 52, 15, 35};
        System.out.print("Original Marks Order :");
        System.out.println(Arrays.toString(marks));
        sortScores(marks);
        System.out.print("Sorted Marks Order :");
        System.out.println(Arrays.toString(marks));

    }
}