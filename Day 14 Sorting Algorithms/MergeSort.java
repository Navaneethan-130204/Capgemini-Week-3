import java.util.Arrays;

public class MergeSort {
    
    public static void sortPrices(int[] price, int left, int right) {
        if(left < right) {
            int mid =  (right + left) / 2;
            sortPrices(price, left, mid);
            sortPrices(price, mid+1, right);
            merge(price, left, mid, right);
        }
    }

    private static void merge(int[] price, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(price, left, leftArr, 0, n1);
        System.arraycopy(price, mid+1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if(leftArr[i] <= rightArr[j]) {
                price[k] = leftArr[i];
                i++;
            }
            else {
                price[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            price[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            price[k] = rightArr[j];
            j++;
            k++;
        }
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
