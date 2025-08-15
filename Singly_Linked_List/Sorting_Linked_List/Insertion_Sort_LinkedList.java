package Singly_Linked_List.Sorting_Linked_List;

class Node {
    int data;
    Node next;
    Node(int data) { this.data = data; }
}

public class Insertion_Sort_LinkedList {
    static Node head;

    static Node insertionSort(Node head) {
        Node sorted = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            sorted = sortedInsert(sorted, current);
            current = next;
        }
        return sorted;
    }

    static Node sortedInsert(Node head, Node newNode) {
        if (head == null || head.data >= newNode.data) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.data < newNode.data) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        return head;
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

        head = insertionSort(head);

        System.out.println("Sorted List:");
        printList(head);
    }
}
