package QUEUE;

import java.util.ArrayDeque;
import java.util.Queue;
//Using Java Collection Framework
public class Queue_JCF {
    public static void main(String[] args) {
        Queue<Integer> Q = new ArrayDeque<>();
        Q.add(1);
        Q.add(2);
        Q.add(3);

        while (!Q.isEmpty()) {
            System.out.println(Q.peek());
            Q.remove();
        }
    }
}
