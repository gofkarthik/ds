package ds.grokking_design_patterns.sliding.window;

public class MaxSumSubArrayOfSizeK {

    static int findMaxSumSubArray(int k,int[] arr){
        int maxSum=0;
        int sum=0;
        int windowStart=0;
        for(int windowEnd=0;windowEnd < arr.length; windowEnd++){
            sum+=arr[windowEnd];
            if(windowEnd >= k-1){
                maxSum=Math.max(sum,maxSum);
                sum-=arr[windowStart];
                windowStart++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
    }
}
