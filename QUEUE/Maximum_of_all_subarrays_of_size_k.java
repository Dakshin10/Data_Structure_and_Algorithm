package QUEUE;

import java.util.Deque;
import java.util.LinkedList;

//We have an array arr[] of size N and an integer K.Find the maximum for each and every contiguous subarray of size K
public class Maximum_of_all_subarrays_of_size_k {
    public static void printMaxOfSubarrays(int[] arr, int k) {
        int n = arr.length;
        if (n == 0 || k <= 0 || k > n) return;

        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) {
                dq.pollLast();
            }
            dq.addLast(i);
            if (i >= k - 1) {
                System.out.print(arr[dq.peekFirst()] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println("Maximums of all subarrays of size " + k + ":");
        printMaxOfSubarrays(arr, k);
    }
}
