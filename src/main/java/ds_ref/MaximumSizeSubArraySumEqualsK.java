package ds_ref;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubArraySumEqualsK {

    public static int maxSubArrayLen1(int[] nums, int k) {
        int sum = 0, max = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, -1);
        // Above step is done because when we do array calculations we start from index 0
        // but when we want the result we want it to start from index 1
        // Example case would be [0,0,0,1] with k = 1, the answer would be 4 however the array index would be from 0 to 3
        // So we add an arbitrary value in our map to account for adding one to our final answer

        //This question builds on top of range sum question where sum(currentIndex) - sum(previousIndex) = k
        //sum(currentIndex) - k = sum(previousIndex), since we store sum uptil index i as key in our map we just need to check
        //if our map contains sum(previousIndex) which is sum(currentIndex) - k if yes we get the length from the previousIndex to
        //the current index if that length is greater than the max length we set the max to that

        for(int i=0; i < nums.length; i++) {
            sum += nums[i];

            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }

         /*   int previousSum = sum - k;
            System.out.println(sum+" "+previousSum);
            if(map.containsKey(previousSum)) {
                int length = i - map.get(previousSum);
                max = Math.max(length, max);
            }*/
        }

        return max;


    }
    public static int maxSubArrayLen(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        int length = nums.length, sum = 0, maxSubLen = 0;
        //Using a hash map to store the sum of all the values before and include nums[i]
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < length; i++) {
            sum += nums[i];
            System.out.print(i+" "+sum+" "+(sum-k)+" "+map);
            if(sum == k) {
                maxSubLen = Math.max(maxSubLen, i + 1);
            } else if(map.containsKey(sum - k)) {
                maxSubLen = Math.max(maxSubLen, i - map.get(sum - k));
            }

            if(!map.containsKey(sum)) {
                map.put(sum, i);
                System.out.print(" "+map);
            }
            System.out.println();
        }
        //System.out.println(map);
        return maxSubLen;
    }

    public static void main(String[] args) {
        int[] nums={-2,-1,2,1};
        int k=1;
        System.out.println(maxSubArrayLen1(nums,k));
    }
}
