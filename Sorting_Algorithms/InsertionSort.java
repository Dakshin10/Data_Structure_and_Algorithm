/**
 * InsertionSort.java
 *
 * This class implements the Insertion Sort algorithm to sort an array of integers in ascending order.
 * 
 * Insertion Sort builds the final sorted array one item at a time by comparing each element
 * with the ones before it and placing it in its correct position.
 *
 * Time Complexity:
 * - Worst Case: O(n^2) — when the array is sorted in reverse
 * - Average Case: O(n^2)
 * - Best Case: O(n) — when the array is already sorted
 *
 * Space Complexity:
 * - O(1) — in-place sorting (no additional memory required)
 *
 * Stable Sort: Yes
 * 
 */

package Sorting_Algorithms;
public class InsertionSort {

    public static void insertionSort(int arr[]) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1; 

            // Move elements of arr[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            // Place the key in the correct location
            arr[j + 1] = key;
        }
    }

    public static void printArr(int arr[]) {
        for (int val : arr)
            System.out.print(val + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {9, 5, 1, 4, 3};
        insertionSort(arr);
        System.out.println("Sorted array:");
        printArr(arr);
    }
}
