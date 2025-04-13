import java.util.Arrays;

public class CountingSort{

    public static void sortAge(int[] age) {

        int n = age.length;

        int max = age[0];
        for(int i = 1; i < n; i++) {
            if(age[i] > max) {
                max = age[i];
            }
        }

        int[] count = new int[max+1];
        for(int i = 0; i < n; i++){
            count[age[i]]++;
        }

        int index = 0;
        for(int i = 0; i <= max; i++) {
            while (count[i] > 0) {
                age[index++] = i;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] age = {12, 15, 10, 18, 12, 17, 15, 11, 10, 18};
        System.out.print("Original Marks Order :");
        System.out.println(Arrays.toString(age));
        sortAge(age);
        System.out.print("Sorted Marks Order :");
        System.out.println(Arrays.toString(age));
    }

}