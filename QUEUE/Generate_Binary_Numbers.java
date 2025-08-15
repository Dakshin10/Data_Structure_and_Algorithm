package QUEUE;

import java.util.LinkedList;
import java.util.Queue;

//Given a number N.The task is to generate and print all binary numbers with decimal values from 1 to N.
public class Generate_Binary_Numbers {
    static void ToBinary(int n){
        Queue<String> q = new LinkedList<>();
        q.add("1");
        while(n-- >0){
            String s1 = q.peek();
            q.remove();
            System.out.print(s1+" ");
            String s2 = s1;
            q.add(s1+"0");
            q.add(s2+"1");

        }
        System.out.println();
    }
    public static void main(String[] args) {
        int n = 2;
        ToBinary(n);

        n =5;
        ToBinary(n);

    }
}
