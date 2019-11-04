package ds.interview.array;

public class Monotonic {


    //pattern will be either -1,0 or 0,1
    //for insatnce 1,2,2,3  -1,0
    public static boolean isMonotonic(int[] A) {
        int store = 0;
        for (int i = 0; i < A.length - 1; ++i) {
            int c = Integer.compare(A[i], A[i+1]);
            if (c != 0) {
                if (c != store && store != 0)
                    return false;
                store = c;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{1,2,2,3}));
    }
}
