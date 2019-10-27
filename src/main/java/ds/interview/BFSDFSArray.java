package ds.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFSDFSArray {

    /*
    create queue
    add element
    poll element
    mark it as visisted/print
    get neighbors
    mark it as visited
     */
    // ArrayList<ArrayList<Integer>>
    //this means first arraylist has index of visitors
    //second array list has its vistied neighbors
    //for exmaple for the input below
    /*

        5 4
        0 1 0 2 0 3 2 4

        Number of nodes 5
        Number of edges 4

        0---1
        | \
        2  3
        |
        4
Arraylist will look like this  where 0 is verted and its neighbors
0 [1, 2, 3]
1 []
2 [4]
https://www.techiedelight.com/depth-first-search-dfs-vs-breadth-first-search-bfs/
     */

//for dfs do the same ..replace queue with stack

    static void bfs(int s, ArrayList<ArrayList<Integer>>
            list, boolean vis[], int nov)
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            int val = queue.poll();
            vis[val] = true;
            System.out.print(val + " ");
            ArrayList<Integer> integers = list.get(val);
            for (Integer intVal : integers) {
                if(!vis[intVal]){
                    queue.add(intVal);
                    vis[intVal]=true;
                }
            }
        }
        // add your code here
    }

    static void dfsIterative(int src, ArrayList<ArrayList<Integer>> list,
                    boolean vis[])
    {
        // add your code here

        Stack<Integer> sc=new Stack<>();
        sc.push(src);
        while(!sc.isEmpty()){
            int vertexVal=sc.pop();
            System.out.print(vertexVal+" ");
            vis[vertexVal]=true;
            ArrayList<Integer> nVals=list.get(vertexVal);
            for(Integer i:nVals){
                if(!vis[i]){
                    vis[i]=true;
                    sc.push(i);
                }
            }
        }
    }

   //print vertex mark true get neibours iterate neighbors and if not marked
   // call for each negibor same function again
    static void dfs(int src, ArrayList<ArrayList<Integer>> list,
                    boolean vis[])
    {
        // add your code here
        vis[src]=true;
        System.out.print(src+" ");
        ArrayList<Integer> nVals=list.get(src);
        for(Integer i:nVals){
            if(!vis[i]){
                dfs(i,list, vis);
            }
        }
    }

    //iterative
    //mark node visited true
    //get neighbors
    // if not visited call recursively
    public static void main(String[] args) {

    }

    //articulation point is where
    //when we remove onve vertex it will disconnect graph into multple components
    //to avoid this connect other components with edge
    //from graph do DFS --it will give DFS spanning tree

    /*
                        1

                     4     2

                         3

                     5       6

                  do dfs for above
              d=1    1

              d=2   4

              d=3  3

              d=4 5   2 d=6

              d=5 6

            discovery points..at what point vertex were discovered

         vertex      1 2 3 4 5 6
         disovered   1 6 3 2 4 5

      find lower path you can reac parent


         vertex      1 2 3 4 5 6
         disovered   1 6 3 2 4 5
              l      1 1 1 1 3 3  //from 5 only we can go 3

              l[v] >= d[u]
         lets take 3 and 4
                1 >= 2 //fails
         lets take 5 and 3
                 3>=3  ..so 3 is articulatiom point

     */

     //    A directed graph is strongly connected if there is a path between all pair of vertices
     // 0->1
    //  |  |
    //  >-->
     // 3   2

    //


}
