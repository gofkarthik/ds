package ds.interview;

public class AllSearchProblems {

    //Median of 2 sorted Arrays
    // Runtime complexity O(logn)
    //simple binary search
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            //this might give overflow
            //because of large integers start+end
            //int m=(start+end)/2;
            //this one will not give overflow
            int m = start + (end - start) / 2;
            if (nums[m] == target) {
                return m;
            } else if (target < nums[m]) {
                end = m - 1;
            } else {
                start = m + 1;
            }
        }
        return -1;
    }

    static int searchRecursive(int[] nums,int target,int start,int end){
        if(start > end){
            return -1;
        }
        int m = start + (end - start) / 2;
        if (nums[m] == target) {
            return m;
        } else if (target < nums[m]) {
            return searchRecursive(nums,target,start,m-1);
        } else {
            return searchRecursive(nums,target,m+1,end);
        }
    }
    void binarySearch() {

    }

    public static void main(String[] args) {
        int a[] = {-1, 0, 3, 5, 9,10,11,12};
       // System.out.println(search(a, 9));
        System.out.println(searchRecursive(a,11,0,a.length-1));
    }
}

