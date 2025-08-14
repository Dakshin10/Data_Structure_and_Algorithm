package Singly_Linked_List;
/**
 * QueueUsingSinglyLinkedList.java
 *
 * This class implements a Queue using a Singly Linked List in Java.
 *
 * It supports basic queue operations:
 * - enqueue(): Insert element at the rear
 * - dequeue(): Remove element from the front
 * - peek(): View the front element
 * - isEmpty(): Check if the queue is empty
 * - display(): Print all queue elements
 *
 * Queue follows FIFO (First In First Out) order.
 *
 * Time Complexity:
 * - enqueue(): O(1)
 * - dequeue(): O(1)
 * - peek(): O(1)
 * - isEmpty(): O(1)
 * - display(): O(n)
 *
 * Space Complexity:
 * - O(n), where n is the number of elements in the queue
 */


public class QueueUsingSinglyLinkedList {

    // Node class for singly linked list
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node front = null, rear = null;

    
    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public void dequeue() {
        if (front == null) {
            System.out.println("Queue Underflow");
            return;
        }
        front = front.next;
        if (front == null)
            rear = null;
    }

    
    public int peek() {
        if (front == null) {
            System.out.println("Queue is empty");
            return -1;
        }
        return front.data;
    }

    
    public boolean isEmpty() {
        return front == null;
    }

   
    public void display() {
        if (front == null) {
            System.out.println("Queue is empty");
            return;
        }
        Node temp = front;
        System.out.print("Queue: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    
    public static void main(String[] args) {
        QueueUsingSinglyLinkedList queue = new QueueUsingSinglyLinkedList();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.display();  // Queue: 10 20 30

        System.out.println("Front element: " + queue.peek()); // 10

        queue.dequeue();
        queue.display();  // Queue: 20 30

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();  // Underflow message

        queue.display();  // Empty message
    }
}
