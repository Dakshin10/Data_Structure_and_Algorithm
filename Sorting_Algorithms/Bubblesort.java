/**
 * Bubblesort.java
 *
 * This class implements the Bubble Sort algorithm to sort an array of integers in ascending order.
 *
 * Bubble Sort works by repeatedly swapping adjacent elements if they are in the wrong order.
 * The process continues until no more swaps are needed.
 * 
 * Optimized with a 'swapped' flag to detect early completion if the array becomes sorted.
 *
 * Time Complexity:
 * - Worst Case: O(n^2)
 * - Average Case: O(n^2)
 * - Best Case: O(n) when the array is already sorted (due to swapped flag)
 * 
 * Space Complexity:
 * - O(1) — In-place sorting, requires no extra space
 * 
 */

package Sorting_Algorithms;

public class Bubblesort {

    /**
     * Sorts the given array using Bubble Sort algorithm.
     * @param arr Array of integers to be sorted
     */
    void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                // Swap if the current element is greater than the next
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no elements were swapped in this pass, the array is sorted
            if (!swapped)
                break;
        }
    }

    public static void main(String[] args) {
        Bubblesort sorter = new Bubblesort();
        int[] arr = {64, 25, 12, 22, 11};

        System.out.println("Original array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        sorter.bubbleSort(arr);

        System.out.println("\nSorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
