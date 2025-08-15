package Singly_Linked_List.Sorting_Linked_List;

class Node {
    int data;
    Node next;
    Node(int data) { this.data = data; }
}

public class Selection_Sort_LinkedList {
    static Node head;

    static void selectionSort(Node head) {
        for (Node temp = head; temp != null; temp = temp.next) {
            Node min = temp;
            for (Node r = temp.next; r != null; r = r.next) {
                if (r.data < min.data) {
                    min = r;
                }
            }
            int x = temp.data;
            temp.data = min.data;
            min.data = x;
        }
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

        selectionSort(head);

        System.out.println("Sorted List:");
        printList(head);
    }
}

