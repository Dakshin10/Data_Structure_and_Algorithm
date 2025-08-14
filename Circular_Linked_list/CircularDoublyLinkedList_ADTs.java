/**
 * CircularDoublyLinkedList.java
 *
 * Implements a Circular Doubly Linked List (CDLL) with all standard operations:
 * - Insert at front
 * - Insert at end
 * - Delete from front
 * - Delete from end
 * - Search for a value
 * - Display forward
 * - Display backward
 *
 * Key Features:
 * - Every node has both a 'next' and 'prev' pointer
 * - The list is circular in both directions
 * - Tail connects to head and vice versa
 *
 * Time Complexity (for all operations):
 * - Insertion/Deletion: O(1) at ends
 * - Search: O(n)
 *
 * Space Complexity:
 * - O(n) for n nodes
 *
 * Applications:
 * - Useful in music players, browser history, round-robin scheduling, etc.
 */
package Circular_Linked_list;

public class CircularDoublyLinkedList_ADTs {

    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = this.prev = null;
        }
    }

    private Node head = null;

    // Insert at front
    public void insertFront(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node tail = head.prev;

            newNode.next = head;
            newNode.prev = tail;

            head.prev = newNode;
            tail.next = newNode;

            head = newNode;
        }
        System.out.println("Inserted " + data + " at front");
    }

    // Insert at end
    public void insertEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            head.prev = head;
            head.next = head;

        } else {
            Node tail = head.prev;

            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
        }
        System.out.println("Inserted " + data + " at end");
    }

    // Delete from front
    public void deleteFront() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        int deleted = head.data;

        if (head.next == head) {
            head = null;
        } else {
            Node tail = head.prev;

            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
        System.out.println("Deleted " + deleted + " from front");
    }

    // Delete from end
    public void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node tail = head.prev;
        int deleted = tail.data;

        if (tail == head) {
            head = null;
        } else {
            Node secondLast = tail.prev;

            secondLast.next = head;
            head.prev = secondLast;
        }
        System.out.println("Deleted " + deleted + " from end");
    }

    // Delete by value (first occurrence)
    public void deleteByValue(int key) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        boolean found = false;

        // Use while loop for circular traversal
        while (true) {
            if (current.data == key) {
                found = true;
                break;
            }
            current = current.next;
            if (current == head) break;  // completed full circle
        }

        if (!found) {
            System.out.println(key + " not found");
            return;
        }

        if (head.next == head && current == head) { // only one node
            head = null;
        } else if (current == head) {
            deleteFront();
            return;
        } else if (current == head.prev) {
            deleteEnd();
            return;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
            System.out.println("Deleted " + key + " by value");
        }
    }

    // Search for a value
    public void search(int key) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        int pos = 0;

        while (true) {
            if (temp.data == key) {
                System.out.println("Found " + key + " at position " + pos);
                return;
            }
            temp = temp.next;
            pos++;
            if (temp == head) break;  // completed full circle
        }

        System.out.println(key + " not found");
    }

    // Display forward
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        System.out.print("Forward: ");

        while (true) {
            System.out.print(temp.data + " ");
            temp = temp.next;
            if (temp == head) break;  // completed full circle
        }
        System.out.println();
    }

    // Display backward
    public void displayBackward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node tail = head.prev;
        Node temp = tail;

        System.out.print("Backward: ");

        while (true) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
            if (temp == tail) break;  // completed full circle
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList_ADTs cdll = new CircularDoublyLinkedList_ADTs();

        cdll.insertFront(10);
        cdll.insertEnd(20);
        cdll.insertFront(5);
        cdll.insertEnd(25);

        cdll.displayForward();   // Forward: 5 10 20 25
        cdll.displayBackward();  // Backward: 25 20 10 5

        cdll.search(20);         // Found 20 at position 2
        cdll.search(100);        // 100 not found

        cdll.deleteFront();
        cdll.deleteEnd();

        cdll.displayForward();   // Forward: 10 20
        cdll.displayBackward();  // Backward: 20 10

        cdll.deleteByValue(10);
        cdll.displayForward();   // Forward: 20
    }
}
