/**
 * Three_way_Quicksort.java
 *
 * Implements 3-way Quick Sort (Dutch National Flag partitioning).
 * Useful when the input has many duplicate keys: it partitions the array
 * into three regions in one pass: < pivot, == pivot, > pivot.
 *
 * Time Complexity:
 * - Best / Average: O(n log n)
 * - Worst: O(n^2) (e.g., consistently poor pivot choices on distinct keys)
 * - With many duplicates: approaches O(n) partitioning and fewer recursive calls
 *
 * Space Complexity:
 * - O(log n) due to recursion stack (in-place algorithm)
 *
 * Stable: No
 *
 */

package Sorting_Algorithms;

public class Three_way_Quicksort {
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
    }

    public static void quickSortThreeWay(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        // Choose pivot as middle element
        int middleIndex = startIndex + (endIndex - startIndex) / 2;
        int pivotValue = array[middleIndex];
        
        // Move pivot to the start for consistent partitioning
        swap(array, startIndex, middleIndex);

        int smallerIndex = startIndex;      // boundary for elements < pivot
        int currentIndex = startIndex + 1;  // index being scanned
        int greaterIndex = endIndex;        // boundary for elements > pivot

        while (currentIndex <= greaterIndex) {
            if (array[currentIndex] < pivotValue) {
                swap(array, currentIndex, smallerIndex);
                currentIndex++;
                smallerIndex++;
            } else if (array[currentIndex] > pivotValue) {
                swap(array, currentIndex, greaterIndex);
                greaterIndex--;
            } else {
                currentIndex++;
            }
        }

        // Recursively sort the partitions
        quickSortThreeWay(array, startIndex, smallerIndex - 1);
        quickSortThreeWay(array, greaterIndex + 1, endIndex);
    }

    public static void swap(int[] array, int index1, int index2) {
        int temporary = array[index1];
        array[index1] = array[index2];
        array[index2] = temporary;
    }

    public static void main(String[] args) {
        int[] inputArray = {5, 3, 9, 3, 3, 7, 3, 1, 3};
        quickSortThreeWay(inputArray, 0, inputArray.length - 1);
        printArray(inputArray);
    }
}
