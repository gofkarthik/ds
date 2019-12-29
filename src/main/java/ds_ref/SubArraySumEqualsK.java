package ds_ref;

public class SubArraySumEqualsK {


    public static int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length <=0 ){
            return 0;
        }
        int windowStart=0;
        int windowSum=0;
        int count=0;
        for(int windowEnd=0;windowEnd<nums.length;windowEnd++){
            windowSum+=nums[windowEnd];
            //System.out.println(windowSum);
            boolean isWindowSum=false;
            while(windowSum >= k){
                windowSum-=nums[windowStart];
                windowStart++;
                isWindowSum=true;
            }
            if(isWindowSum){
                count++;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums={-1,-1,1};
        int k=0;
        System.out.println(subarraySum(nums,k));
    }

}
