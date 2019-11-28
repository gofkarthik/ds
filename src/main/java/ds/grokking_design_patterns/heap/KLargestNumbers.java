package ds.grokking_design_patterns.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Input: [3, 1, 5, 12, 2, 11], K = 3
 * Output: [5, 12, 11]
 *
 */
public class KLargestNumbers {

    public static List<Integer> findKLargestNumbers(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        for(int i=0;i<k;i++){
            priorityQueue.add(nums[i]);
        }
        System.out.println(priorityQueue);
        for(int i=k-1;i<nums.length;i++){
            Integer peek = priorityQueue.peek();
            if(nums[i] > peek){
                priorityQueue.poll();
                priorityQueue.add(nums[i]);
            }
        }
        System.out.println("Kth largest number "+priorityQueue.peek());
        return new ArrayList<>(priorityQueue);
    }
    public static void main(String[] args) {

        List<Integer> result = KLargestNumbers.findKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
        System.out.println("Here are the top K numbers: " + result);
        result = KLargestNumbers.findKLargestNumbers(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Here are the top K numbers: " + result);
        result = KLargestNumbers.findKLargestNumbers(new int[] { 1, 9, 2, 7, 8, 10,12,13 }, 4);
        System.out.println("Here are the top K numbers: " + result);
    }
}
