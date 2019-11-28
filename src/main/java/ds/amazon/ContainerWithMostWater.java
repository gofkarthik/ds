package ds.amazon;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical
 * lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

   So technically you need to find the maximum area where you can store water
   So we need to find 2 lines identical or one is greater or shorter and get the max area

   For instance in givne array
    1,8,6,2,5,4,8,3,7
    you can 8 and 8 and min is 8. but area will be then 8 * (6-4) = 16 (6 and 4 are index)
    you can 8 and 7 and min is 7. but area will be then 7 * (8-1) = 49 (6 and 4 are index)

    Two pointer O(N)
    intialize max
    start first pointer from left and second pointer from right
    if left is smaller or equal to right then move from left and calc Math.max(max,newValue)
    else if right is smaller move from right and calculate max

    //if you use for loop ,one side gets incremented irrespective of whatever happens
     use while loop
        Two pointer ,greedy approach
 */
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int maxarea = 0;
        int i=0;
        int j=height.length-1;
        while(i<j) {
            if(height[i] <= height[j]){
                maxarea = Math.max(maxarea,(height[i] *(j-i)));
                i++;
            }else {
               maxarea = Math.max(maxarea,(height[j] *(j-i)));
               j--;
            }
        }

        return maxarea;
    }

    public static void main(String[] args) {
        int h[]={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(h));
    }
}
