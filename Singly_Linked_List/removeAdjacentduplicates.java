package Singly_Linked_List;

public class removeAdjacentduplicates {
    public static class Node {
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head, tail;

    public static void add(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        }
        tail.next = newNode;
        tail = newNode;
    }

    static void removeAdjacentDuplicates() {
        Node curr = head;
        while (curr != null && curr.next != null) {
            if (curr.data == curr.next.data) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
    }


    public static void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main method
    public static void main(String[] args) {
        add("a");
        add("a");
        add("b");
        add("b");
        add("c");
        add("a");
        add("a");

        System.out.println("Original list:");
        printList();

        removeAdjacentDuplicates();

        System.out.println("After removing adjacent duplicates:");
        printList();
    }
}
