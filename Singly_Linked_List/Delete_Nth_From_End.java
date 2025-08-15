package Singly_Linked_List;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Delete_Nth_From_End {
    static Node head;

    // Function to delete nth node from end (Two-pass method)
    public static void deleteNthNodefromEnd(int n) {
        if (head == null || n <= 0) {
            System.out.println("Invalid operation");
            return;
        }

        // 1️⃣ Find size of the linked list
        int size = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        if (n > size) {
            System.out.println("Position out of range");
            return;
        }

        // 2️⃣ If we need to delete head
        if (n == size) {
            head = head.next;
            return;
        }

        // 3️⃣ Find previous node of the node to be deleted
        int idxToFind = size - n;
        Node prev = head;
        for (int i = 1; i < idxToFind; i++) {
            prev = prev.next;
        }

        // 4️⃣ Delete node
        prev.next = prev.next.next;
    }

    // Helper function to print linked list
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create list: 1 -> 2 -> 3 -> 4 -> 5 -> null
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original Linked List:");
        printList(head);

        deleteNthNodefromEnd(2); // Delete 2nd from end (4)

        System.out.println("After Deletion:");
        printList(head);
    }
}
