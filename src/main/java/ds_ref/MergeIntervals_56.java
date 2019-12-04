package ds_ref;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/merge-intervals/
 */

/*
   [1,3] [2,4] [6,7]

   In above 1,3 2,4 are overlapping so merge them into one
   merge by getting the max end time
   1,3 2,4 => 1,4

   1,4 6,7 => no overlapping so keep 6,7 as it is

   [1,3] [2,6] [5,7] [9,10]
      1,6 5,7 9,10
      1,6 5,7 still overlapping => 1,7
      9,10 not overlapping so output is
      1,7 9,10

    Algo
    i)  Sort the array
    ii) Crete a stack and push the first element of array
    iii) check for merge for 2 given
    iv) if merge then pop element from stack and put the element back to stack
      merge logic -- let say 1  3 from left max ,from right mim and diff between them> 0

    v)  else push the stack
 */
public class MergeIntervals_56 {

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 0) {
            return new int[][]{};
        }
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        Stack<int[]> stack=new Stack<>();
        stack.push(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[] element=intervals[i];
            int[] stkElement=stack.peek();
            if(isValidMerge(stkElement,element)){
                stack.pop();
                int maxValue=Math.max(element[1],stkElement[1]);
                stack.push(new int[]{stkElement[0],maxValue});
            }else{
                stack.push(element);
            }
        }
        int[][] res=new int[stack.size()][2];
        int i=0;
        while(!stack.isEmpty()){
            int[] a=stack.pop();
            res[i++]=a;
        }
        return res;
    }

    static boolean isValidMerge(int[] a,int []b){
        int left=Math.max(a[0],b[0]);
        int right=Math.min(a[1],b[1]);
        return right - left >= 0;
    }

    public static void main(String[] args) {
        int[][] a = {
              //  {2,6},{1,3},{8,10},{15,18}
                {1,4},{4,5}
        };
        merge(a);
    }
}
