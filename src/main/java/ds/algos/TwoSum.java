package ds.algos;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *  for example lets say array = [2,7,8,1]
 *  target = 9
 *  so answer is 0 and 1 because indicies of o[2] and 1[7] is 9
 *  */

import java.util.HashMap;
import java.util.Map;

/**
 * create hashmap and put elements in it -- so lookup becomes o[1] /iterate over array
 * iterate over array again and find its completement in the map .. coplmenent is target - iterative element
 * one important point whoel finding complement makes sure that it is not same element getting iterated
 * Time complexity O(n) and Space complexity O(n)
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> elements=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            elements.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target-nums[i];
            if(elements.containsKey(complement) && elements.get(complement) != i){
                return new int[]{i,elements.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
