import java.util.Arrays;

public class HeapSort {

    public static void sortSalary(int[] salary) {
        int n = salary.length;

        for(int i = n/2-1; i >= 0; i--) {
            heapify(salary, n, i);
        }

        for(int i = n-1; i > 0; i--) {
            int temp = salary[0];
            salary[0] = salary[i];
            salary[i] = temp;

            heapify(salary, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;

        if(left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if(right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if(largest != i) {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;

            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {

        int[] salary = {55000, 32000, 78000, 45000, 61000, 29000, 72000, 39000, 83000, 50000};
        System.out.print("Original Marks Order :");
        System.out.println(Arrays.toString(salary));
        sortSalary(salary);
        System.out.print("Sorted Marks Order :");
        System.out.println(Arrays.toString(salary));
    }
}