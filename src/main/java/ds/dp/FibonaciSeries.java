package ds.dp;

public class FibonaciSeries {


    // let say for f(6)

    /*
                                          f(6)
                      f(5)                                     f(4)
              f(4)            f(3)                     f(3)              f(2)
       f(3)         f(2)      f(2)  f(1)            f(2) f(1)            f(1)  f(0)
     f(2) f(1)   f(1)  f(0)

     */
    int fibSeries(int n) {
        if (n == 1) return 0;
        else if (n == 2) return 1;
        else return fibSeries(n - 1) + fibSeries(n - 2);
    }

    //DP Momoization
    //in above we can see f(3) is repeated like others
    int val[] = new int[20];

    void init() {
        for (int i = 0; i < val.length; i++) {
            val[i] = -1;

        }
    }

    int fibSeries_1(int n) {
        if (n == 1) return 0;
        else if (n == 2) return 1;
        if (val[n] != -1) {
            return val[n];
        } else {
            val[n] = fibSeries(n - 1) + fibSeries(n - 2);
            return val[n];
        }
    }

    //fibonaci series in divide and cnquer takes exponential time
    //with memoization it takes only O(n)

    public static void main(String[] args) {
        FibonaciSeries fb = new FibonaciSeries();
        System.out.println(" sum "+ fb.fibSeries(5));
        fb.init();
        System.out.println(" sum_1 "+fb.fibSeries_1(5));
    }

}
