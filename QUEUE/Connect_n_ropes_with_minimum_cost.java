package QUEUE;

import java.util.PriorityQueue;

//Given are N ropes of different lengths, the task is to connect these ropes in to one rope with minimum cost,
//such that the cost to connect two ropes is equal to the sum of their lengths.
public class Connect_n_ropes_with_minimum_cost {

    static int Connect(int arr[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i =0; i<arr.length; i++){
            pq.add(arr[i]);
        }
        int sum = 0;
        while(pq.size()>1){
            int first = pq.poll();
            int second = pq.poll();
            sum += (first+second);
            pq.add((first+second));
        }
        return sum;
    }

    public static void main(String[] args) {
        int ropesLength[] = {4,3,2,8,6};
        System.out.println("Total cost for connecting ropes is: "+Connect(ropesLength));
    }
}
