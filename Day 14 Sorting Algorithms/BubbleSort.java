import java.util.Arrays;

public class BubbleSort {

    public static void sortMarks(int[] marks) {
        int n = marks.length;
        boolean swapped;

        for(int i = 0; i < n-1; i++) {
            swapped = false;
            for(int j = 0; j < n-i-1; j++) {
                if(marks[j] > marks[j+1]) {
                    int temp = marks[j];
                    marks[j] = marks[j+1];
                    marks[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
    }

    public static void main(String[] args) {

        int[] marks = {65 ,62, 88, 25, 86 ,97, 78, 32, 52, 15, 35};
        System.out.print("Original Marks Order :");
        System.out.println(Arrays.toString(marks));
        sortMarks(marks);
        System.out.print("Sorted Marks Order :");
        System.out.println(Arrays.toString(marks));
    }
}
