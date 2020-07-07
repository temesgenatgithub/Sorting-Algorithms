package src;
import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        int[] arr = {2, 3, 100, -8, 6, 8, 7, 0, 2, 40, 6, 9, 60, -1};
        Sorter sort = new Sorter();

        
        // sort.usingInsertionSort(arr, 0, arr.length - 1);
        // sort.usingBubbleSort(arr, 0, arr.length - 1);
        sort.usingMergeSort(arr, 0, arr.length - 1);
        // sort.usingQuickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }
}