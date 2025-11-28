import java.util.*;

// this might be completely useless but I will add this here in case, binary search method and one sorting method (shell sort)

public class ArrayUtils {
    
    // --- SHELL SORT ---
    public static void shellSort(int[] arr) {
        int n = arr.length;
        
        for (int gap = n / 2; gap > 0; gap /= 2) {
            
            //gapped insertion sort
            for (int i = gap; i < n; i++) {
                int score = arr[i];
                int j = i;
                
                //shift gap sorted elements until the correct place is found
                while (j >= gap && arr[j - gap] > score) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                
                //place the score at the right position
                arr[j] = score;
                
            }
        }
    }
    // --- BUBBLE SORT ---
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i; j++) {
                // compare other elements 
                if (arr[j] > arr[j + 1]) {
                    // swap them if they are in the wrong order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // if no two elements are were swapped
            if (!swapped) {
                break;
            }
        }
    }
    // --- BINARY SEARCH ---
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (arr[mid] == target) {
                return mid;
            } else if (target < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1; //if not found
    }
    // --- LINEAR SEARCH ---
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // return index if found
            }
        }
        return -1; // return -1 if not found
    }
}
