package ds_ref;

public class JumpGame2 {

    public static int jump(int[] nums) {
        if(nums == null || nums.length < 0 ||nums.length == 1){
            return 0;
        }

        int ladder=nums[0];
        int stairs=nums[0];
        int jump=1;
        for(int i=1;i<nums.length;i++){
            if(i == nums.length-1) return jump;
            if(i+nums[i] > ladder)
                ladder=i+nums[i];
            stairs--;
            if(stairs == 0){
                jump++;
                stairs=ladder-i;
            }
        }
        return jump;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }
}
