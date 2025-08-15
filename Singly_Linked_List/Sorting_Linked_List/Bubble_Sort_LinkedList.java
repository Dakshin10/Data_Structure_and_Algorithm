package Singly_Linked_List.Sorting_Linked_List;

class Node {
    int data;
    Node next;
    Node(int data) { this.data = data; }
}

public class Bubble_Sort_LinkedList {
    static Node head;

    static void bubbleSort(Node head) {
        if (head == null) return;
        boolean swapped;
        Node ptr1;
        Node lptr = null;

        do {
            swapped = false;
            ptr1 = head;
            while (ptr1.next != lptr) {
                if (ptr1.data > ptr1.next.data) {
                    int temp = ptr1.data;
                    ptr1.data = ptr1.next.data;
                    ptr1.next.data = temp;
                    swapped = true;
                }
                ptr1 = ptr1.next;
            }
            lptr = ptr1;
        } while (swapped);
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(5);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(3);

        System.out.println("Original List:");
        printList(head);

        bubbleSort(head);

        System.out.println("Sorted List:");
        printList(head);
    }
}
