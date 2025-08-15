package Singly_Linked_List;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ZigZagLinkedList {
    static Node head;

    public static void zigZag() {
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node firstNode = head;
        Node secondNode = reverse(slow.next);
        slow.next = null;

        while(firstNode!= null && secondNode!= null){
            Node temp1 = firstNode.next;
            Node temp2 = secondNode.next;
            firstNode.next = secondNode;
            secondNode.next = temp1;

            firstNode = temp1;
            secondNode = temp2;
        }

    }
    public static Node reverse(Node head){
        Node prev = null,next = null ,curr =head;
        while (curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        System.out.println("Original List:");
        printList(head);

        zigZag();

        System.out.println("ZigZag List:");
        printList(head);
    }
}

