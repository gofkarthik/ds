package ds_ref;

import java.util.ArrayList;
import java.util.List;

public class SprialMatrix_54 {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        if(matrix == null ||matrix.length ==0){
            return ans;
        }
        int[] dr={0,1,0,-1};
        int[] dc={1,0,-1,0};
        int r=0;
        int c=0;
        int di=0;
        int R=matrix.length;
        int C=matrix[0].length;
        boolean[][] seen=new boolean[R][C];
        for(int i=0;i<R*C;i++){
            System.out.println(r+" "+c);
            ans.add(matrix[r][c]);
            seen[r][c]=true;
            int cr=r+dr[di];
            int cc=c+dc[di];
            if(cr >=0 && cr<R && cc>=0 && cc<C &&!seen[cr][cc]){
                System.out.println(r+"inseide"+ " "+c);
                r=cr;
                c=cc;
            }else{
                System.out.println(r+"outside"+ " "+c);
                di=(di+1)%4;
                r=r+dr[di];
                c=c+dc[di];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix={
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        spiralOrder(matrix);
    }
}
