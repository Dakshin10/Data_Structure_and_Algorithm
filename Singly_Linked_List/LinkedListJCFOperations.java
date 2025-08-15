package Singly_Linked_List;
import java.util.LinkedList;

public class LinkedListJCFOperations {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        // Add elements (like push at the end)
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("After add(): " + list);

        // Add element at first
        list.addFirst(5);
        System.out.println("After addFirst(): " + list);

        // Add element at last
        list.addLast(40);
        System.out.println("After addLast(): " + list);

        // Push (like stack - adds at the front)
        list.push(0);
        System.out.println("After push(): " + list);

        // Peek (first element without removing)
        System.out.println("Peek first: " + list.peek());
        System.out.println("Peek last: " + list.peekLast());

        // Pop (removes first element)
        System.out.println("Popped element: " + list.pop());
        System.out.println("After pop(): " + list);

        // Remove by index
        list.remove(2);
        System.out.println("After remove(index=2): " + list);

        // Remove first and last
        list.removeFirst();
        list.removeLast();
        System.out.println("After removeFirst() & removeLast(): " + list);

        // Check if contains
        System.out.println("Contains 20? " + list.contains(20));

        // Size of list
        System.out.println("Size of list: " + list.size());

        // Clear list
        list.clear();
        System.out.println("After clear(): " + list);
    }
}
