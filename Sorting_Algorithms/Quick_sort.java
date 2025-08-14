/**
 * Quick_sort.java
 *
 * This class implements the Quick Sort algorithm using recursion.
 * It follows the divide-and-conquer paradigm by selecting a pivot element
 * and partitioning the array into subarrays of elements less than and greater than the pivot.
 *
 * Time Complexity:
 * - Best Case: O(n log n)
 * - Average Case: O(n log n)
 * - Worst Case: O(n^2) — occurs when the pivot is the smallest or largest element every time
 *
 * Space Complexity:
 * - O(log n) — due to recursive call stack
 *
 * Stable Sort: No
 *
 */

package Sorting_Algorithms;
public class Quick_sort {

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void quicksort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int pidx = partision(arr, si, ei);
        quicksort(arr, si, pidx - 1); // left part
        quicksort(arr, pidx + 1, ei); // right part
    }

    public static int partision(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1; // to make place for smaller than pivot

        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Put pivot in the correct position
        i++;
        int temp = arr[i];
        arr[i] = arr[ei];
        arr[ei] = temp;

        return i;
    }

    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 5, 2, 8};
        quicksort(arr, 0, arr.length - 1);
        printArr(arr);
    }
}
