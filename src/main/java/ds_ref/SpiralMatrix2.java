package ds_ref;

public class SpiralMatrix2 {

    public int[][] generateMatrix(int n) {
        if(n == 0){
            return new int[][]{};
        }
        int[][] nw=new int[n][n];
        int R=n;
        int C=n;
        int[] dr={0,1,0,-1};
        int[] dc={1,0,-1,0};
        int di=0;
        int r=0;
        int c=0;
        int number=1;
        int nr=0;
        int nc=0;
        boolean[][] seen=new boolean[R][C];
        for(int i=0;i<R*C;i++){
            // System.out.println("a "+i+" "+r+" "+c);
            nw[r][c]=number++;
            seen[r][c]=true;
            nr=r+dr[di];
            nc=c+dc[di];

            //  System.out.println("a1 "+i+" "+nr+" "+nc);
            if(nr >=0 && nr <nw.length && nc >=0 && nc < nw.length
                    && !seen[nr][nc]){
                r=nr;
                c=nc;
            }else{
                di=(di+1)%4;
                r=r+dr[di];
                c=c+dc[di];
            }
        }
        return nw;
    }
}
