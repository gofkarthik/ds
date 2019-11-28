package ds.amazon;


/*Given n non-negative integers representing an elevation map
 where the width of each bar is 1, compute how much water it is able to trap after raining.

  https://www.youtube.com/watch?v=wz00uI9mDXA

  Let say numbers are 2 1 0 2 0 0 1 3

   3                        -

   2    -

   1        -     -      -

   o
         0   1  2  3  4 5 6 7 8

   Now solution :
   For eah bar get maximum water it can save
   Sum up total water trapped by each row

   let say index 2 .. max water it can save is
   min(leftHighestBar,rightHighestBar) - itsHeight
   = min( 2(index(0)) , 3(index(7)) - 0(index2) = 2
   = it can say 2 units of water

  code:
   iterate over array and get left highest of all bar and store in array
   itearte over array from right
            get right highest
            get left highest for that element
            get min - currentheight
            add it to total amount


*/
public class TrappingRainWater {

    static int trap(int[] height) {
        int totalAmount=0;
        if(height == null || height.length <= 0){
            return totalAmount;
        }
        int[] leftHighest = new int[height.length];
        leftHighest[0]=0;
        for (int i = 0; i < height.length; i++) {
            if((i + 1) < height.length) {
                leftHighest[i + 1] = Math.max(leftHighest[i], height[i]);
            }
        }
        int rightHighest=0;

        for(int i=height.length-1;i>-0;i--){
            rightHighest=Math.max(height[i],rightHighest);
            int val=Math.min(leftHighest[i],rightHighest)-height[i];
            if(val < 0) val=0;
            totalAmount+=val;
        }
        return totalAmount;
    }


    public static void main(String[] args) {
        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
