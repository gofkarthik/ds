package ds_ref.dp;

public class FibonacciSeries {


    static int[]  dp=new int[9];

    static int fibSeries(int n){
        if(n <=1){
           // System.out.println(n);
            return  n;
        }
        if(dp[n-1] == 0){
            dp[n-1]=fibSeries(n-1);
        }
        if(dp[n-2] == 0){
            dp[n-2]=fibSeries(n-2);
        }
        return   fibSeries(dp[n-1]) + fibSeries(dp[n-2]);
    }

    public static void main(String[] args) {
        System.out.println(fibSeries(9));
        for (int i : dp) {
            System.out.println(i);
        }

    }
}
