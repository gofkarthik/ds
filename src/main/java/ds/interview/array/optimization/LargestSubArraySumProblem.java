package ds.interview.array.optimization;


import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.

Kadane’s Algorithm:

Time Complexity: O(n)
Algorithmic Paradigm: Dynamic Programming

 Create 2 variables
 localSum = a[0]
 maxSum = a[0]

 run array from i-> 1 to n
 localSum = max(a[i],localSum+a[i])
 maxSum = max(localSum,maxSum)

 return maxSum

 */
public class LargestSubArraySumProblem {

    public static void main (String[] args){
        try{
            //calling via system.in
            /*BufferedReader br=new BufferedReader(new
                    InputStreamReader(System.in));
            int t=Integer.parseInt(br.readLine());
            while(t >0){
                int n=Integer.parseInt(br.readLine());
                int[] a=new int[n];
                String line = br.readLine();
                String[] strs = line.trim().split("\\s+");
                for (int i = 0; i < n; i++) {
                    a[i] = Integer.parseInt(strs[i]);
                }
                int maxSumValue = getMaxSumValue(a);
                System.out.println(maxSumValue);*/
            int[] a={1,2,3,-2,5};
            System.out.println(getMaxSumValue(a));
        }catch(Exception e){

        }
    }

    private static int getMaxSumValue(int[] a) {
        int maxSumValue=a[0];
        int maxCurrentValue=a[0];
        for(int i=1;i<a.length;i++){
            int newMaxCurrent=maxCurrentValue+a[i];
            if(a[i] > newMaxCurrent){
                maxCurrentValue=a[i];
            }else{
                maxCurrentValue=newMaxCurrent;
            }
            if(maxSumValue < maxCurrentValue){
                maxSumValue = maxCurrentValue;
            }
        }
        return maxSumValue;
    }
}
