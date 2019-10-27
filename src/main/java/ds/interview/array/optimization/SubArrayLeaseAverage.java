package ds.interview.array.optimization;

/*

Find the subarray with least average

Given an array arr[] of size n and integer k such that k <= n.

Examples :

Input:  arr[] = {3, 7, 90, 20, 10, 50, 40}, k = 3
Output: Subarray between indexes 3 and 5
The subarray {20, 10, 50} has the least average
among all subarrays of size 3.

Input:  arr[] = {3, 7, 5, 20, -10, 0, 12}, k = 2
Output: Subarray between [4, 5] has minimum average

Solution

Minimum sum has minimum average / maximum sum has maximum average
so no need to find average
find group of elements which has

let say k=3
statindex = 0
find sum of first three elements 3+7+90 =100
Mark this as min sum : minSum=100
now start loop from i=3 to rest
for each element find currentsum += (currentlement - prevelement(i-k)) // 3 - 0
cur < minsum ,cursum = minsum
              startindex = cur-k+1

retur startindex,k-1

Time O(n)
Space O(1)

*/


/*package whatever //do not write package name here */

class SubArrayLeaseAverage {
    static void getIndex(int a[],int n,int k){
        if(n < k )return;
        int minSum = 0;
        int startIndex=0;
        for(int i=0;i<k;i++){
            minSum +=i;
        }
        int curSum = minSum;
        for(int i=k;i<n;i++){
            curSum+= a[i]-a[i-k];
            if(curSum < minSum){
                minSum = curSum;
                startIndex = i-k+1;
            }
        }
        System.out.println(startIndex+" "+(startIndex+k-1));
    }
    public static void main (String[] args) {
        try{
            //int []arr={30,20,10};
            int arr[] = new int[] { 3, 7, 90, 20, 10, 50, 40 };
            /*BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            //test case
            String s=br.readLine();
            String s1[]=br.readLine().trim().split(" ");
            int k=Integer.parseInt(s1[0]);
            int n=Integer.parseInt(s1[1]);
            System.out.println(k+" "+n);
            String s2[]=br.readLine().trim().split(" ");
            int[] a=new int[s2.length];
            int i=0;
            for(String si:s2){
                a[i++]=Integer.parseInt(si);
            }*/

            getIndex(arr,arr.length,3);
        }catch(Exception e){

        }
    }
}
