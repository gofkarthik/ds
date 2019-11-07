package ds.grokking_design_patterns.sliding.window;

import java.util.Arrays;

class AverageOfSubarrayOfSizeK {

    public static double[] findAverages(int K, int[] arr) {
        double result[] = new double[K];
        //double[] result = new double[arr.length - K + 1];
        int windowStart = 0;
        double sum = 0.0;
        for(int windowEnd=0;windowEnd < arr.length;windowEnd ++){
            sum +=arr[windowEnd];
            if(windowEnd >= K-1){
                result[windowStart] = sum/K;
                sum -= arr[windowStart];
                windowStart++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        double[] result = AverageOfSubarrayOfSizeK.findAverages(5, new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2});
        System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
    }
}
