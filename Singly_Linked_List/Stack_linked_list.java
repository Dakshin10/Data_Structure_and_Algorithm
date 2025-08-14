package Singly_Linked_List;
/**
 * Stack Implementation using Singly Linked List in Java
 * 
 * This class implements the basic Abstract Data Types (ADTs) of a Stack:
 * - push(): Insert an element onto the stack
 * - pop(): Remove the top element from the stack
 * - peek(): View the top element without removing it
 * - isEmpty(): Check if the stack is empty
 * 
 * Time Complexity:
 * - Push: O(1)
 * - Pop: O(1)
 * - Peek: O(1)
 * - isEmpty: O(1)
 * 
 * Space Complexity:
 * - O(n) for storing n elements in the linked list
 * 
 */


public class Stack_linked_list {

    // Node class to represent each element in the stack
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Stack class implementing all ADTs
    public static class Stack {
        Node top;  // Top of the stack

        public Stack() {
            top = null;
        }
        public boolean isEmpty() {
            return top == null;
        }

        public void push(int data) {
            Node newNode = new Node(data);
            newNode.next = top;
            top = newNode;
            System.out.println(data + " pushed to stack");
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            int popped = top.data;
            top = top.next;
            System.out.println(popped + " popped from stack");
            return popped;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return top.data;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        System.out.println("Is stack empty? " + stack.isEmpty());

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element is: " + stack.peek());

        stack.pop();
        stack.pop();

        System.out.println("Is stack empty? " + stack.isEmpty());

        stack.pop();
        stack.pop(); 
    }
}

