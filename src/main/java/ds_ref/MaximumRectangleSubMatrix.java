package ds_ref;

public class MaximumRectangleSubMatrix {

    class KadaneResult{
        int start;
        int end;
        int maxSum;

        KadaneResult(int start,int end,int maxSum){
            this.start=start;
            this.end=end;
            this.maxSum=maxSum;
        }
    }

    private KadaneResult getKadaneResult(int arr[]){
        int start=0;
        int end=0;
        int s=0;
        int maxSoFar=arr[0];
        int maxEnd=0;
        for(int i=0;i<arr.length;i++){
            maxEnd = maxEnd + arr[i];
            if(maxSoFar < maxEnd){
                maxSoFar=maxEnd;
                start=s;
                end=i;
            }
            if(maxEnd < 0){
                maxEnd=0;
                s=i+1;
            }
        }
        return new KadaneResult(start,end,maxSoFar);
    }

    private int maxSum(int[][] input){

        int rows=input.length;
        int cols=input[0].length;
        int tmp[]=new int[rows];


        int currentSum=0;
        int maxSum=0;
        int maxLeft=0;
        int maxRight=0;
        int maxTop=0;
        int maxBottom=0;

        for(int l=0;l<cols;l++){
            for (int i = 0; i < rows; i++) {
                tmp[i]=0;
            }
            for(int r=l;r<cols;r++) {
                for (int k = 0; k < rows; k++) {
                    try {
                        tmp[k]+=input[k][r];
                    } catch (Exception e) {
                        System.out.println(r+" "+k);
                        e.printStackTrace();
                    }
                }
                KadaneResult kadaneResult = getKadaneResult(tmp);
                currentSum=kadaneResult.maxSum;
                if(currentSum > maxSum) {
                    maxSum=currentSum;
                    maxTop = kadaneResult.start;
                    maxBottom = kadaneResult.end;
                    maxRight= r;
                    maxLeft=l;
                }
            }
           // System.out.println();
        }
        //System.out.println("Result "+ maxSum +" "+maxTop+" "+maxBottom+" "+maxRight+" "+maxLeft);
       /* int result=0;
        for(int i=maxTop;i<=maxBottom;i++){
            for(int j=maxLeft;j<=maxRight;j++){
                result+=input[i][j];
            }
        }
        System.out.println(result);*/
        System.out.println(maxSum);
        return 0;
    }

    public static void main(String args[]){
        int t=0;
        while(t-->0){

        }
        int input[][] = {{ 2,  1, -3, -4,  5},
                { 0,  6,  3,  4,  1},
                { 2, -2, -1,  4, -5},
                {-3,  3,  1,  0,  3}};
        MaximumRectangleSubMatrix saw = new MaximumRectangleSubMatrix();
        //System.out.println(saw.maxSum(input));
        saw.maxSum(input);
    }
}
