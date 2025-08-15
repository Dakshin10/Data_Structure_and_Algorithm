package Singly_Linked_List;
//Palindrome a Linked List
    //1. Find the mid of Linked List
    //2. Reverse the 2nd half of the Linked List
    //3.Check if 1st half == 2nd half 
    //            (left)       (right)

    //two pointer method 
    //slow pointer= head + 1
    //fast pointer= head + 2

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Palindrome_LinkedList {
    static Node head;

    // Find middle using slow/fast pointers
    public static Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;          // +1
            fast = fast.next.next;     // +2
        }
        return slow;
    }

    public static boolean checkPalindrome(Node head) {
        if (head == null || head.next == null) { // 0 or 1 node
            return true;
        }

        Node midNode = findMiddle(head);


        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;  
        Node left = head;
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        if (checkPalindrome(head)) {
            System.out.println("Linked List is Palindrome");
        } else {
            System.out.println("Linked List is NOT Palindrome");
        }
    }
}
