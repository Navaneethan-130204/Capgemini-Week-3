import java.util.Arrays;

public class InsertionSort {

    public static void sortId(int[] id){
        int n = id.length;
        for(int i = 1; i < n; i++) {
            int key = id[i];
            int j = i - 1;

            while (j >= 0 && id[j] > key) {
                id[j+1] = id[j];
                j--;
            }
            id[j+1] = key;
        }
    }

    public static void main(String[] args) {
        int[] id = {105, 203, 150, 189, 102, 250, 175, 130, 145, 199};
        System.out.print("Original Marks Order :");
        System.out.println(Arrays.toString(id));
        sortId(id);
        System.out.print("Sorted Marks Order :");
        System.out.println(Arrays.toString(id));
    }
}
