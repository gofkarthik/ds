package ds_ref;

public class UnqiuePath2_63 {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
    /*    if(obstacleGrid == null || obstacleGrid.length == 0 ||
                obstacleGrid[0].length == 0){
            return 0;
        }
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;

        int[][] grid=new int[m][n];

        for(int i=0;i<m ;i++ ){
            if(obstacleGrid[i][0] != 1){
                grid[i][0] =1;
            }else{
                break;
            }
        }

        for(int j=0;j<n ;j++ ){
            if(obstacleGrid[0][j] != 1){
                grid[0][j] =1;
            }else{
                break;
            }
        }

        for(int i=1;i<m ;i++ ){
            for(int j=1;j<n ;j++ )
            {
                if(obstacleGrid[i][j] != 1){
                    grid[i][j]=obstacleGrid[i][j-1] + obstacleGrid[i-1][j];
                }
            }
        }

        return grid[m-1][n-1];

*/
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int height = obstacleGrid.length;
        int width = obstacleGrid[0].length;

        int[][] paths = new int[height][width];

        // first column
        for (int i = 0; i < height; i++) {
            if (obstacleGrid[i][0] != 1) {
                paths[i][0] = 1;
            } else {
                break;
            }
        }

        // first row
        for (int j = 0; j < width; j++) {
            if (obstacleGrid[0][j] != 1) {
                paths[0][j] = 1;
            } else {
                break;
            }
        }

        // for spaces not at first row or first column
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                if (obstacleGrid[i][j] != 1) {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
        }

        return paths[height - 1][width - 1];
    }


    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{
                {0,0,0},{0,1,0},{0,0,0}
        }));
    }
}

