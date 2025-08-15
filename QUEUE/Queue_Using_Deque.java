package QUEUE;

import java.util.Deque;
import java.util.LinkedList;

public class Queue_Using_Deque {
    static class Stack{
        Deque<Integer> deque = new LinkedList<>();

        public void push(int data){
            deque.addLast(data);
        }
        public int remove(){
            return deque.removeFirst();
        }
        public int peek(){
            return deque.getFirst();
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("Peek : "+s.peek());
        System.out.println("Deleted Element : "+s.remove());
        System.out.println("Deleted Element : "+s.remove());
        System.out.println("Deleted Element : "+s.remove());
       
     }
}
