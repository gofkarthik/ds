package ds.interview;

import java.util.*;

public class RopesProblem {

    //Remember the sorting order is binary heap
    //it maintains the sorted order in terms of binary heap

    //Time O(nlogn) spaceO(n)
   /* Input: ropes = [8, 4, 6, 12]
    Output: 58
    Explanation: The optimal way to connect ropes is as follows
1. Connect the ropes of length 4 and 6 (cost is 10). Ropes after connecting: [8, 10, 12]
            2. Connect the ropes of length 8 and 10 (cost is 18).
             Ropes after connecting: [18, 12]
            3. Connect the ropes of length 18 and 12 (cost is 30).
    Total cost to connect the ropes is 10 + 18 + 30 = 58
*/

    public static int minCost(List<Integer> ropes) {
    /*   Queue<Integer> ropesQueue=new PriorityQueue<>(ropes);
       int totalCost=0;
       while (ropesQueue.size() > 1){
           int value=ropesQueue.poll() + ropesQueue.poll();
           ropesQueue.add(value);
           totalCost+=value;
       }
*/
        Queue<Integer> pq = new PriorityQueue<>(ropes);
        int totalCost = 0;
        while (pq.size() > 1) {
            int cost = pq.poll() + pq.poll();
            pq.add(cost);
            totalCost += cost;
        }
        return totalCost;

    }

    public static int connectSticks(int[] sticks) {
        List<Integer> st=new ArrayList<>();
        for(int i:sticks){
            st.add(i);
        }
        Queue<Integer> qp=new PriorityQueue<>(st);
        int cost=0;
        System.out.println(qp);
        while(qp.size() > 1){
            int costLc=qp.poll()+qp.poll();
            qp.add(costLc);
            System.out.println(qp);
            cost +=costLc;
        }
        System.out.println(cost);
        return cost;
    }

    public static void main(String[] args) {
        int []sticks={2,4,3};
        connectSticks(sticks);
       // System.out.println(minCost(Arrays.asList(20, 4, 8, 2)));
       /* Integer a[]={8, 4, 6, 12};
        List<Integer> al= Arrays.asList(a);
        Queue<Integer> pq = new PriorityQueue<>(al);
   *//*     for (Integer integer : pq) {
            System.out.print(integer+" ");
        }
        System.out.println();*//*
        pq = new PriorityQueue<>(al.size(),Collections.reverseOrder());
        for (Integer integer : al) {
            pq.add(integer);
        }
        System.out.println(pq);
        System.out.println(pq.offer(3));
        System.out.println(pq);
        System.out.println(pq.add(5));
        System.out.println(pq);
        System.out.println(pq.add(9));
        System.out.println();
        for (Integer integer : pq) {
            System.out.print(integer+" ");
        }*/
        //add and offer are same.. add throws exception
        //offer returns false it
        /*
        E 	peek()
Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
E 	poll()
Retrieves and removes the head of this queue, or returns null if this queue is empty.
boolean 	remove(Object o)
Removes a single instance of the specified element from this queue, if it is present.
         */
    }
}
