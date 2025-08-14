package QUEUE;

public class Queue_LinkedList {
    static class Node{
        Node next;
        int data;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static Node head = null;
    static Node tail = null;

    public static boolean isEmpty(){
        return head == null && tail == null;
    }

    public static void add(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = tail = newNode;
        }
        tail.next = newNode;
        tail=newNode;
    }

    public static int remove(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        int front  = head.data;
        if(tail == head){
            tail = head = null;
        }else{
            head = head.next;
        }
        return front;
    }

    public static int peek(){
         if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return head.data;
    }

    public static void main(String[] args) {

        add(1);
        add(2);
        add(3);

        while (!isEmpty()) {
            System.out.println(peek());
            remove();
        }
    }

}
