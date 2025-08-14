package QUEUE;

import java.util.*;

public class Stack_Using_Two_Queues {
    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();

    public static boolean isEmpty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    public static void push(int data) {
        if (!q1.isEmpty()) {
            q1.add(data);
        } else {
            q2.add(data);
        }
    }

    public static int pop() {
        if (isEmpty()) {
            System.out.println("The Stack is empty");
            return -1;
        }

        int top = -1;

        if (!q1.isEmpty()) {
            while (q1.size() > 1) {
                q2.add(q1.remove());
            }
            top = q1.remove();
        } else {
            while (q2.size() > 1) {
                q1.add(q2.remove());
            }
            top = q2.remove();
        }

        return top;
    }

    public static int peek() {
        if (isEmpty()) {
            System.out.println("The Stack is empty");
            return -1;
        }

        int top = -1;

        if (!q1.isEmpty()) {
            while (!q1.isEmpty()) {
                top = q1.remove();
                q2.add(top);
            }
        } else {
            while (!q2.isEmpty()) {
                top = q2.remove();
                q1.add(top);
            }
        }

        return top;
    }

    public static void main(String[] args) {
        push(0);
        push(1);
        push(2);
        push(3);

        while (!isEmpty()) {
            System.out.println(peek());
            pop();
        }
    }
}
