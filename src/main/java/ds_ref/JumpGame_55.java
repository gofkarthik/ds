package ds_ref;

public class JumpGame_55 {

    public static boolean canJump(int[] nums) {
        boolean[] jumpArray=new boolean[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i!=0){
                if(!jumpArray[i]){
                    break;
                }
            }
            for(int j=0;j<=nums[i];j++){
                int position=i+j;
                if(position < jumpArray.length){
                    jumpArray[position] = true;
                }
            }
        }
        return jumpArray[jumpArray.length-1];
    }

    public static void main(String[] args) {
       canJump(new int[]{3,2,1,0,4});
    }
}
