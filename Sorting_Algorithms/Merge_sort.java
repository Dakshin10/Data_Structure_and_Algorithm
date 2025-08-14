/**
 * Merge_sort.java
 *
 * This class implements the Merge Sort algorithm using recursion and the divide-and-conquer approach.
 * It recursively splits the array into two halves, sorts them, and merges them back together.
 *
 * Time Complexity:
 * - Best Case: O(n log n)
 * - Average Case: O(n log n)
 * - Worst Case: O(n log n)
 *
 * Space Complexity:
 * - O(n) — Additional space required for the temporary array during merging
 *
 * Stable Sort: Yes
 *
 */


package Sorting_Algorithms;
public class Merge_sort {
    

    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void mergeSort(int[] arr,int si,int ei){
        if(si>=ei){
            return;
        }
        int mid = si + (ei - si)/2;
        mergeSort(arr, si, mid);    //left part
        mergeSort(arr, mid+1, ei);  //right part
        merge(arr, si, mid, ei);
    } 

    public static void merge(int arr[],int si,int mid,int ei){
        int[] tempArr = new int[ei - si+1];
        int i = si;   //iterator for left part
        int j = mid+1; //iterator for right part
        int k = 0; //iterator for temp array

        while(i<= mid && j<=ei){
            if(arr[i]<arr[j]){
                tempArr[k]=arr[i];
                i++; k++;
            }else{  
                tempArr[k]=arr[j];
                j++; k++;
            }
        }
        //left part
        while(i<=mid){
            tempArr[k++] = arr[i++];
        }
        //right part
        while(j<=ei){
            tempArr[k++]=arr[j++];
        }

        //copy temp to original array
        for(k=0, i=si;k<tempArr.length;k++, i++){
            arr[i] =  tempArr[k];
        }

    }

    public static void main(String[] args) {
        int arr[]  = {6,3,9,5,2,8};
        mergeSort(arr, 0, arr.length - 1);
        printArr(arr);
    }

    
}


