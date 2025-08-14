/**
 * SinglyLinkedList_ADTs.java
 *
 * This class implements a Singly Linked List and supports:
 * - Insertions (at beginning, end, or specific position)
 * - Deletions (from beginning, end, or specific position)
 * - Forward traversal
 *
 * Time Complexity:
 * - Insertions: O(1) at beginning, O(n) at end or specific position
 * - Deletions: O(1) at beginning, O(n) at end or specific position
 * - Display: O(n)
 *
 * Space Complexity:
 * - O(n), where n is the number of nodes
 */

package Singly_Linked_List;

public class SinglyLinkedList_ADTs {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;

    // Insert at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Insert at a given position (1-based index)
    public void insertAtPosition(int data, int pos) {
        if (pos <= 1) {
            insertAtBeginning(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        int i = 1;
        while (temp != null && i < pos - 1) {
            temp = temp.next;
            i++;
        }
        if (temp == null) {
            insertAtEnd(data);
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete from beginning
    public void deleteFromBeginning() {
        if (head == null) return;
        head = head.next;
    }

    // Delete from end
    public void deleteFromEnd() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    // Delete from position
    public void deleteFromPosition(int pos) {
        if (head == null || pos <= 1) {
            deleteFromBeginning();
            return;
        }
        Node temp = head;
        int i = 1;
        while (temp.next != null && i < pos - 1) {
            temp = temp.next;
            i++;
        }
        if (temp.next == null) {
            deleteFromEnd();
            return;
        }
        temp.next = temp.next.next;
    }

    // Display the list
    public void display() {
        Node temp = head;
        System.out.print("List: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        SinglyLinkedList_ADTs sll = new SinglyLinkedList_ADTs();

        sll.insertAtBeginning(30);
        sll.insertAtBeginning(20);
        sll.insertAtEnd(40);
        sll.insertAtPosition(25, 2);
        sll.display();

        sll.deleteFromPosition(2);
        sll.display();

        sll.deleteFromEnd();
        sll.display();

        sll.deleteFromBeginning();
        sll.display();
    }
}
