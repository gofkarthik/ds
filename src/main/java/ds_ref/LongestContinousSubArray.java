package ds_ref;

public class LongestContinousSubArray {

    public static int maxSubArray(int[] nums) {
        if(nums == null || nums.length <=0 ){
            return 0;
        }
        int maxEndingHere=0;
        int maxSoFar=nums[0];

        int start=0;
        int end=0;
        int s=0;
        for(int i=0;i<nums.length;i++){
            maxEndingHere=nums[i]+maxEndingHere;
            if(maxSoFar < maxEndingHere){
                start=s;
                end=i;
                maxSoFar = maxEndingHere;
            }
            if(maxEndingHere < 0){
                maxEndingHere=0;
                s=i+1;
            }
        }
        for(int i=start;i<=end;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
        return maxSoFar;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
