package QUEUE;

public class Queue_Arrays {
    static class Queue {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front  = -1;
        }

        public boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public boolean isfull(){
            return (rear+1)%size == front;
        }

        // Add an element 
        public void add(int data) {
            if (isfull()) {
                System.out.println("Queue is full");
                return;
            }
            if(front == -1){
                front = 0;
            }
            rear= (rear+1)%size;
            arr[rear] = data;
        }

        // Remove an element
        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            if(rear==front){
                rear = front = -1;
            }else{
                front = (front+1)%size;
            }
            return front;
        }

        // Peek front element
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String[] args) {
        Queue Q = new Queue(5);
        Q.add(1);
        Q.add(2);
        Q.add(3);

        while (!Q.isEmpty()) {
            System.out.println(Q.peek());
            Q.remove();
        }
    }
}
