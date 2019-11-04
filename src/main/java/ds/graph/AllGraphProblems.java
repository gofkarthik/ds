package ds.graph;

import java.util.*;

public class AllGraphProblems {


    /*
    2
    5 4
    0 1 0 2 0 3 2 4
    3 2
    here it says
    for 0 neighbors are 1 2 3
    for 2 neighbirs are 4
    for 3 neighbors are 2
     0 - 1
     | \
     2  3
     |
     4

     Output will be 0 1 2 3 4

     s -> from node 0
     list will have the below
     0 [1, 2, 3]
     1 []
     2 [4]
    */
    static void bfs_search(int s, List<List<Integer>> list) {
        Queue<Integer> ss = new LinkedList<>();
        boolean vis[] = new boolean[20];
        ss.add(s);
        while (!ss.isEmpty()) {
            Integer val = ss.poll();
            if (!vis[val]) {
                vis[val] = true;
            }
            System.out.print(val + " ");
            try {
                List<Integer> integers = list.get(val);
                for (Integer child : integers) {
                    if (!vis[child]) {
                        ss.add(child);
                        vis[child] = true;
                    }
                }
            } catch (Exception e) {

            }
        }
        System.out.println();
    }

    static void df_search(int s, List<List<Integer>> list) {
        Stack<Integer> ss = new Stack<>();
        boolean vis[] = new boolean[20];
        ss.add(s);
        while (!ss.isEmpty()) {
            Integer val = ss.pop();
            if (!vis[val]) {
                vis[val] = true;
            }
            System.out.print(val + " ");
            try {
                List<Integer> integers = list.get(val);
                for (Integer child : integers) {
                    if (!vis[child]) {
                        ss.push(child);
                        vis[child] = true;
                    }
                }
            } catch (Exception e) {

            }
        }
        System.out.println();
    }

    static void df_search_rr(int s, List<List<Integer>> list, boolean vis[]) {
        vis[s] = true;
        System.out.print(s + " ");
        List<Integer> childNodes = list.get(s);
        for (Integer i : childNodes) {
            if (!vis[i]) {
                df_search_rr(i, list, vis);
            }
        }
        System.out.println();
    }

    //rotten oranges
    //Basic things -- to see in 4 directions get code and add them

    /*
      Any row/column in a grid can be fetched by using code . for instance

            0   1   2
       0    2   1   1

       1    1   1   0

       2    0   1   1

        R = totalNoOfRows = 3
        C = totalNoOfColumns = 3
                             r  c
       let take this value a[2][0] = 0

       code = r*C + c = 0 =? 2*3+0 = 6

       r = code / C = 6/3 = 2
       c = code % C = 6%3 = 0

       For going 4 directional , formula is   r[] = {-1,0,1,0}
                                              c[] = {0,-1,0,1}
       Lets take a[1][1] = 1 //expected output should be 0,1 1,0 2,1 1,2

       code = 1 * 3 +1=4
       r = 4/3 = 1
       c= 4%3 = 1
       Run k from 0 to 3
               k =0  r + r[k]  , c + c[k] = 0,1
               k =1  1,0
               k=2   2,1
               k=3   1,2

     Algo
      Queue , Map<int,int> depth
      Iterte matrix
      if element has 2
      queue.add(code) //element having 2
      depth(code,0) //intial depth of element code and its depth 0

      bfs --
      int totaltime =0
      while(!queue.isempty){
        queue.poll //get code
        //iterate over its four directions
         ..get r c using k get locations
         for each k
         get nr and nc
         nr >=0 nr <R nc >=0 nc <C grid[nr][nc] == 1
         queue.add(nw=code(nr*C+c))
         map.put(nw,map.get(codeO+1)
         totaltime map.get(nw)
      }

      //now there may be chances an orange not rotten at ll
      /check if anything has 1 in all elemtn then return -1
      //for (int[] r:grid){
            for(int v:r){
                if(v ==1) return -1
            }
      }

      Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

       so iter only rows in grid and even if one

     */

    public int orangesRotting(int[][] grid) {
        int[] r1 = {-1, 0, 1, 0};
        int[] c1 = {0, -1, 0, 1};
        int depth = 0;
        int R = grid.length;
        int C = grid[0].length;
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> mc = new HashMap<>();
        //put all 2
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 2) {
                    int code = i * C + j;
                    queue.add(code);
                    mc.put(code, 0);
                }
            }
        }
        while(!queue.isEmpty()){
            Integer code = queue.poll();
            int r = code/ C;
            int c = code % C;
            for(int k=0;k<=3;k++){
                int nr= r + r1[k];
                int nc= c + c1[k];
                if(nr >=0 && nr < R && nc >=0 && nc < C && grid[nr][nc] == 1){
                    grid[nr][nc]=2;
                    int nrCode= nr*C+nc;
                    queue.add(nrCode);
                    mc.put(nrCode, mc.get(code)+1);
                    depth=mc.get(nrCode);
                }
            }
        }
        for(int[] r :grid){
            for(int i:r){
                if(i == 1)return -1;
            }
        }

        return depth;
    }

    //alien dictionary



    //no of files same problem as above
    //file server problem
    static int minimumHours(int rows,int column,List<List<Integer>> data){
        int minHours=0;
        Integer [][] grid=new Integer[data.size()][];

        for(int i=0;i<data.size();i++){
            List<Integer> integers = data.get(i);
            grid[i] = integers.toArray(new Integer[integers.size()]);
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dk = {0, -1, 0, 1};
        Queue<Integer> queue=new ArrayDeque<>();
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i = 0; i< rows; i++){
            for(int j = 0; j< column; j++){
                int val=grid[i][j];
                if(val == 1){
                    int code=i* column +j;
                    queue.offer(code);
                    mp.put(code,0);
                }
            }
        }

        while(!queue.isEmpty()){
            Integer code = queue.poll();
            int r=code/ column;
            int c=code% column;
            for(int k=0;k<=3;k++){
                int nr=r+dr[k];
                int nc=c+dk[k];
                if(nr >=0 && nr < rows && nc >=0 && nc < rows && grid[nr][nc] == 0){
                    grid[nr][nc] = 1;
                    int nrCode = nr* column +nc;
                    queue.offer(nrCode);
                    mp.put(nrCode,mp.get(code)+1);
                    minHours = mp.get(nrCode);
                }
            }
        }

        return minHours;
    }

    public static void main(String[] args) {
        List<List<Integer>> ab = new ArrayList<>();
    /*    ab.add(Arrays.asList(1, 2, 3));
        ab.add(new ArrayList<Integer>());
        ab.add(Arrays.asList(4));
        ab.add(new ArrayList<Integer>());
        ab.add(new ArrayList<Integer>());
        bfs_search(0, ab);
        System.out.println("dfs");
        df_search(0, ab);
        System.out.println("dfs_iter");
        df_search_rr(0, ab, new boolean[10]);
        System.out.println();*/
        ab=new ArrayList<>();
        ab.add(Arrays.asList(0,1,1,0,1));
        ab.add(Arrays.asList(0,1,0,1,0));
        ab.add(Arrays.asList(0,0,0,0,1));
        ab.add(Arrays.asList(0,1,0,0,0));
        System.out.println(minimumHours(4,5,ab));
        ab=new ArrayList<>();
        ab.add(Arrays.asList(1,0,0,0,0));
        ab.add(Arrays.asList(0,1,0,0,0));
        ab.add(Arrays.asList(0,0,1,0,0));
        ab.add(Arrays.asList(0,0,0,1,0));
        ab.add(Arrays.asList(0,0,0,0,1));
        System.out.println(minimumHours(5,5,ab));
        ab=new ArrayList<>();
        ab.add(Arrays.asList(0,0,1,0,0,0));
        ab.add(Arrays.asList(0,0,0,0,0,0));
        ab.add(Arrays.asList(0,0,0,0,0,1));
        ab.add(Arrays.asList(0,0,0,1,0,0));
        ab.add(Arrays.asList(0,1,0,0,0,0));
        System.out.println(minimumHours(5,6,ab));

        //no of islands
    }

}
