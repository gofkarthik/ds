package ds_ref;

public class UniquePath_62 {

    public static int uniquePaths(int m, int n) {
        if(m == 0 || n == 0) {
            return 0;
        }
        //populate all top rows
        int [][] grid = new int[m][n];
        for(int i=0;i<m;i++){
            grid[i][0]=1;
        }

        for(int j=0;j<n;j++){
            grid[0][j] = 1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                grid[i][j] = grid[i][j-1]+grid[i-1][j];
            }
        }
        return grid[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,2));

    }
}
