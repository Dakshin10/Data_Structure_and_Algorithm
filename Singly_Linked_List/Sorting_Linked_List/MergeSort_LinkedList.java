package Singly_Linked_List.Sorting_Linked_List;

class Node {
    int data;
    Node next;
    Node(int data) { this.data = data; }
}

public class MergeSort_LinkedList {
    static Node head;

    static Node mergeSort(Node h) {
        if (h == null || h.next == null) return h;

        Node middle = getMiddle(h);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        Node left = mergeSort(h);
        Node right = mergeSort(nextOfMiddle);

        return sortedMerge(left, right);
    }

    static Node sortedMerge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        if (a.data <= b.data) {
            a.next = sortedMerge(a.next, b);
            return a;
        } else {
            b.next = sortedMerge(a, b.next);
            return b;
        }
    }

    static Node getMiddle(Node h) {
        if (h == null) return h;
        Node slow = h, fast = h;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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

        head = mergeSort(head);

        System.out.println("Sorted List:");
        printList(head);
    }
}

