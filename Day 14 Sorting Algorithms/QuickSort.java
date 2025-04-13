import java.util.Arrays;

public class QuickSort {

    public static void sortPrices(int[] price, int low, int high) {
        if(low < high) {
            int pi = partition(price, low, high);
            sortPrices(price, low, pi-1);
            sortPrices(price, pi+1,high);
        }
    }

    private static int partition(int[] price, int low, int high) {
        int pivot = price[high];
        int i = low-1;
        for(int j = low; j < high; j++) {
            if(price[j] < pivot) {
                i++;
                int temp = price[i];
                price[i] = price[j];
                price[j] = temp;
            }
        }
        int temp = price[i+1];
        price[i+1] = price[high];
        price[high] = temp;
        return i+1;
    }

    public static void main(String[] args) {

        int[] price = {450, 300, 550, 150, 275, 600, 400, 125, 500, 350};
        System.out.print("Original Marks Order :");
        System.out.println(Arrays.toString(price));
        sortPrices(price, 0 , price.length-1);
        System.out.print("Sorted Marks Order :");
        System.out.println(Arrays.toString(price));
    }
}
