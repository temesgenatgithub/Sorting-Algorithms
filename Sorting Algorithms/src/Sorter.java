package src;
/**
 * This is the Sorter class, 
 * which can be used to perform insertion, bubble, merge and quick
 * Only for arrays
 */
public class Sorter {
    /**
     * Implements Insertion sort 
     * @param arr the array that needs to be sorted 
     * @param low the starting index
     * @param high the ending index
     */
    public void usingInsertionSort(int[] arr, int low, int high) {
        for (int i = low +1; i < high + 1; ++i) { 
            int curr = arr[i];
            int j = i - 1;
  
            while (j >= low && arr[j] > curr) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = curr;
        }
    }

    /**
     * Implements Bubble sort
     * @param arr the array to be sorted
     * @param low the starting index
     * @param high the ending  index
     */
    public void usingBubbleSort(int[] arr, int low, int high) {
        for (int i = low; i < high; i++) {
            for (int j = low; j < high-1; j++) {
                if (arr[j] > arr[j+1]) 
                { 
                    // swap arr[j+1] and arr[i] 
                    int temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                } 
            }
        }
    }

    /***
     * Implements Quick sort
     * Recursive
     * uses private helper method called partition
     * 
     * @param arr   the array needing to be sorted
     * @param low   the starting index
     * @param high  the ending index
     */
    public void usingQuickSort(int[] arr, int low, int high) {
        if (low < high) 
        { 
            int pIndex = partition(arr, low, high); 
  
            // Recursively sort elements 
            usingQuickSort(arr, low, pIndex-1); 
            usingQuickSort(arr, pIndex+1, high); 
        }
    }

    /***
     * Implements Merge sort
     * Recursive
     * used private helper method called merge
     * 
     * @param arr
     * @param low
     * @param high
     */
    public void usingMergeSort(int[] arr, int low, int high) {
        if (low < high) { 
            int middle = (low + high) / 2; 
  
            // Recursively sort elemenst 
            usingMergeSort(arr, low, middle); 
            usingMergeSort(arr, middle + 1, high); 
  
            // Merge the sorted halves 
            merge(arr, low, middle, high); 
        } 
    }

    /***
     * This method partitions given array using the last element as a pivot
     * This is helper method for the Quick sort
     * 
     * @param arr
     * @param low
     * @param high
     * @return the next pivot
     */
    private int partition(int arr[], int low, int high) {
        int pivot = arr[high]; 
        int i = (low-1);
        for (int j=low; j<high; j++) 
        { 
            // if less than the pivot, swap with ith element
            if (arr[j] < pivot) 
            { 
                i++; 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap the pivot
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
        
        return i+1; 
    }

    /***
     * This method merges array in order with a given middle element
     * This is a helper function fo the Merge sort
     * 
     * @param arr
     * @param low
     * @param middle
     * @param high
     */
    private void merge(int arr[], int low, int middle, int high) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = middle - low + 1; 
        int n2 = high - middle;
  
        // Create temp arrays and copy data
        int L[] = new int[n1]; 
        int R[] = new int[n2]; 
        for (int i = 0; i < n1; ++i) 
            L[i] = arr[low + i]; 
        for (int j = 0; j < n2; ++j) 
            R[j] = arr[middle + 1 + j]; 
  
        // preparing the index for merging and merges
        int i = 0, j = 0; 
        int k = low; 
        while (i < n1 && j < n2) { 
            if (L[i] <= R[j]) { 
                arr[k] = L[i]; 
                i++; 
            } 
            else { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        // Copy remaining elements if any
        while (i < n1) { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
        while (j < n2) { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
}