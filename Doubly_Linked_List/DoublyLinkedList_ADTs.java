package Doubly_Linked_List;

class Node {
    int data;
    Node prev, next;

    public Node(int data) {
        this.data = data;
        prev = next = null;
    }
}

public class DoublyLinkedList_ADTs {

    public static Node head, tail;

    public static void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public static void AddLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public static void AddPosition(int data, int pos) {
        Node newNode = new Node(data);

        // Case 1: Empty list
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // Case 2: Insert at beginning
        if (pos == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            return;
        }

        // Traverse to (pos - 1)
        Node temp = head;
        for (int i = 0; i < pos - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        // Case 3: Insert at end
        if (temp.next == null) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            return;
        }

        // Case 4: Insert in middle
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    public static void DeleteFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            System.out.println("Deleted Node is : " + head.data);
            head = tail = null;
            return;
        }
        System.out.println("Deleted Node is : " + head.data);
        head = head.next;
        head.prev = null;
    }

    public static void DeleteLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            System.out.println("Deleted Node is : " + head.data);
            head = tail = null;
            return;
        }
        System.out.println("Deleted Node is : " + head.data);
        tail = tail.prev;
        tail.next = null;
    }

    public static void DeletePosition(int pos) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // Case 1: Delete head
        if (pos == 0) {
            System.out.println("Deleted Node is : " + head.data);
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            return;
        }

        Node temp = head;
        for (int i = 0; temp != null && i < pos; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position Out of index");
            return;
        }

        System.out.println("Deleted Node is : " + temp.data);

        // Case 2: Delete tail
        if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
            return;
        }

        // Case 3: Delete in the middle
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    public static void deleteByValue(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                if (current == head) {
                    DeleteFirst();
                } else if (current == tail) {
                    DeleteLast();
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                return;
            }
            current = current.next;
        }
    }

    public static int getAtPosition(int pos) {
        if (pos < 0)
            return -1;

        Node temp = head;
        for (int i = 0; temp != null && i < pos; i++) {
            temp = temp.next;
        }
        return (temp != null) ? temp.data : -1;
    }

    public static boolean search(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == value)
                return true;
            temp = temp.next;
        }
        return false;
    }

    public static void updateAtPosition(int pos, int newValue) {
        if (pos < 0)
            return;

        Node temp = head;
        for (int i = 0; temp != null && i < pos; i++) {
            temp = temp.next;
        }

        if (temp != null) {
            temp.data = newValue;
        }
    }

    public static void traverseForward() {
        Node temp = head;
        System.out.print("Forward: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void traverseBackward() {
        Node temp = tail;
        System.out.print("Backward: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    public int GetLength() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void main(String[] args) {
        // Add elements at the beginning
        addFirst(30);
        addFirst(20);
        addFirst(10);
        traverseForward(); // Forward: 10 20 30

        // Add elements at the end
        AddLast(40);
        AddLast(50);
        traverseForward(); // Forward: 10 20 30 40 50

        // Add element at position
        AddPosition(25, 2); // Insert 25 at index 2
        traverseForward(); // Forward: 10 20 25 30 40 50

        // Traverse backward
        traverseBackward(); // Backward: 50 40 30 25 20 10

        // Delete head
        DeleteFirst(); // Deletes 10
        traverseForward(); // Forward: 20 25 30 40 50

        // Delete tail
        DeleteLast(); // Deletes 50
        traverseForward(); // Forward: 20 25 30 40

        // Delete at position
        DeletePosition(1); // Deletes 25
        traverseForward(); // Forward: 20 30 40

        // Delete by value
        deleteByValue(30);
        traverseForward(); // Forward: 20 40

        // Search for element
        System.out.println("Search 40: " + search(40)); // true
        System.out.println("Search 30: " + search(30)); // false

        // Get element at position
        System.out.println("Element at pos 1: " + getAtPosition(1)); // 40

        // Update element at position
        updateAtPosition(0, 99);
        traverseForward(); // Forward: 99 40
    }
}
