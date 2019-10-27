package ds.interview;

import java.util.*;

/*
Remember this is one pass hash table
in map put array value and its index
Given an array  You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

time and space O(n)

 */
public class TwoSum {

    static int[] getIndices(int[] nums, int target){
            Map<Integer,Integer> map=new HashMap<>();
            int index=0;
            for(int i:nums){
                int diff=target-i;
                if(map.containsKey(diff)){
                    return new int[]{map.get(diff),index};
                }

                map.put(i,index++);
            }
            return null;
        }

        //Given a list of positive integers nums and an int target,
        // return indices of the two numbers such that they add up to a target - 30.
        //if mulitple pairs give largest
    //below gives multiple paors

    static List<Integer> getIndices_1(int[] nums, int target){
        target=target-30;
        Map<Integer,Integer> map=new HashMap<>();
        List<Integer> list= new ArrayList<>();
        int index=0;
        for(int i:nums){
            int diff=target-i;
            if(map.containsKey(diff)){
               // return new int[]{map.get(diff),index};
                //add cannot be overriden
               // list.set(0,map.get(diff));
                //list.set(1,index);
                list.add(map.get(diff));
                list.add(index);
            }

            map.put(i,index++);
        }
        return list;
    }

    static List<Integer> getIndices_1_larger(int[] nums, int target){
        target=target-30;
        Map<Integer,Integer> map=new HashMap<>();
        List<Integer> list= Arrays.asList(-1,-1);
        int index=0;
        int largest=0;
        for(int i:nums){
            int diff=target-i;
            if((diff > largest || map.get(i) >largest)&&map.containsKey(diff)){
                // return new int[]{map.get(diff),index};
                //add cannot be overriden
                 list.set(0,map.get(diff));
                 list.set(1,index);
                 largest=Math.max(diff,map.get(diff));
            }

            map.put(i,index++);
        }
        return list;
    }
    public static void main(String[] args) {
        int[] a={2, 7, 11, 15};
        int[] indices = getIndices(a, 9);
       // System.out.println(indices[0]+" "+indices[1]);
        int[] a1={20, 50, 40, 25, 30, 10};
        //0,2,1,5 ==but return 1,5 becuase 50 is largestt
        System.out.println(getIndices_1(a1,90));
        System.out.println(getIndices_1_larger(a1,90));
    }
}
