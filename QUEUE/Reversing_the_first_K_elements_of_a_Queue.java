package QUEUE;
import java.util.*;
//We have an integer k and a queue of integers, we need to reverse the order of the first
// kelements of the queue, leaving the other elements in the same relative order
public class Reversing_the_first_K_elements_of_a_Queue {
    public static void reverseFirstK(Queue<Integer> q, int k) {
        if (q.isEmpty() || k > q.size() || k <= 0) {
            return; 
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            stack.push(q.poll());
        }
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }
        int size = q.size();
        for (int i = 0; i < size - k; i++) {
            q.add(q.poll());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);
        q.add(70);

        int k = 4;

        System.out.println("Original Queue: " + q);
        reverseFirstK(q, k);
        System.out.println("Queue after reversing first " + k + " elements: " + q);
    }
}
