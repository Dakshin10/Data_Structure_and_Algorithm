/**
 * SelectionSort.java
 *
 * This class implements the Selection Sort algorithm.
 * It works by repeatedly finding the minimum element from the unsorted part
 * and putting it at the beginning.
 *
 * Time Complexity:
 * - Best Case: O(n^2)
 * - Average Case: O(n^2)
 * - Worst Case: O(n^2)
 *
 * Space Complexity:
 * - O(1) — In-place sorting
 *
 * Stable Sort: No
 *
 */
package Sorting_Algorithms;
public class selectionsort {

    public static void selection(int arr[]){
        int n = arr.length;

        for(int i=0;i<n-1;i++){

            int minIdx = i;

            for(int j=i;j<n;j++){

                if( arr[j] < arr[minIdx] ){

                    minIdx = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }
    public static void disparr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {5,2,7,1,8,6};
        selection(arr);
        disparr(arr);
    }   
}
