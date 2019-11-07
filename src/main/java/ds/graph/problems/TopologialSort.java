package ds.graph.problems;


import java.util.ArrayList;
import java.util.Stack;

/**
 * Works only for DAG
 * Runtime Complexity - O(V+E)
 * Space Complexity - O(V+E)
 * Same as DFS but using one extra stack
 * <p>
 * Sorts given actions in such a way,if there is a dependency of one action on other,then
 * the dependent action always comes later that its parent action
 * <p>
 * A     E
 * | /   |
 * >     >
 * C     D
 * <p>
 * C can be done only after  A and E
 * D can be done only after E
 * AECD
 * <p>
 * Algo dry run:
 * =============
 * Use stack
 * <p>
 * Take all verties
 * -- take a vertex and keep visting his neighbors
 * during each visite mark neighbor as true
 * if no more neighbors push to stack
 * keep visting again
 * topologicalSort(vertex,bool[] visited,stack){
 * <p>
 * }
 * <p>
 * // Why must a graph with a topological sort be acyclic and why must an acyclic
 * graph have a topological sort?
 * a graph is cyclic, then you have some cycle with, say, vertices A->B->C->A->B->C->A... Then,
 * if you arrive at A before B or C, you won't have satisfied the sort property
 * (because B and C will not have been visited). If you arrive, instead,
 * at B before A or C, you also won't have satisfied the sort property.
 * And, if you arrive at C... well, you know. With a directed cycle,
 * no matter which point in the cycle you arrive at first, there is no possible way to satisfy the
 * topological sort.
 * <p>
 * A topological sort must be acyclic and directed
 * <p>
 * https://leetcode.com/tag/topological-sort/
 * <p>
 * Application
 * Build systems
 * Apt-get(Advanced packating tool)
 * Task scheduling
 * Pre-requisit problems
 */
public class TopologialSort {

    //https://leetcode.com/tag/topological-sort/

    static void topologicalSort(Stack<Integer> stack, ArrayList<ArrayList<Integer>>
            list, Integer vertex, boolean[] visited) {
        visited[vertex] = true;
        ArrayList<Integer> neighbors = list.get(vertex);
        for (Integer i : neighbors) {
            if (!visited[i]) {
                topologicalSort(stack, list, i, visited);
            }
        }
        stack.add(vertex);
    }

    static int[] topoSort(ArrayList<ArrayList<Integer>>
                                  list, int N) {
        // add your code here

        boolean[] visited = new boolean[list.size()];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < list.size(); i++) {
            visited[i] = false;
        }
        for (int i = 0; i < list.size(); i++) {
            topologicalSort(stack, list, i, visited);
        }
        int i = 0;
        int[] result = new int[stack.size()];
        //System.out.println(stack);
        for (Integer i1 : stack) {
            result[i++] = i1;
        }
        return result;

    }

    private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack,
                                 ArrayList<ArrayList<Integer>> list) {
        if (recStack[i])
            return true;

        if (visited[i])
            return false;
        visited[i] = true;
        recStack[i] = true;
        ArrayList<Integer> children = list.get(i);
        for (Integer c : children)
            if (isCyclicUtil(c, visited, recStack, list))
                return true;
        recStack[i] = false;
        return false;
    }

    private boolean isCyclic(ArrayList<ArrayList<Integer>> list,
                             int V) {

        boolean[] visited = new boolean[10];
        boolean[] recStack = new boolean[10];
        for (int i = 0; i < V; i++)
            if (isCyclicUtil(i, visited, recStack, list))
                return true;

        return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> aa1=new ArrayList<>();
        ArrayList<Integer> aa=new ArrayList<>();
        aa.add(1);
        aa.add(2);
        aa1.add(aa);
        ArrayList<Integer> aa11=new ArrayList<>();
        //aa11.add(2);
        aa1.add(aa11);
        ArrayList<Integer> aa12=new ArrayList<>();
        //aa12.add(0);
        aa12.add(3);
        aa1.add(aa12);
        ArrayList<Integer> aa13=new ArrayList<>();
        //aa13.add(6);
        aa1.add(aa13);
        TopologialSort ts=new TopologialSort();
        System.out.println(ts.isCyclic(aa1,3));
    }
    /*Course schedule
    // Input is given in from edge list . Refer below
    // https://www.khanacademy.org/computing/computer-science/algorithms/graph-representation/a/representing-graphs
    // We need to find the course schedule
    // Given [1,0] [2,1] [2,3] [3,2]
    // To do 1 we should do 0  ..so in this ordeer 0-1-2-3 (3 and 2 acycle)
    //  Technically we need to find is there a cycle or not..lets use DFS and indegree
    // Indegree -- no of edges points to a node
    //   -> N <-   N has 2 in-degree     N<-  N has one in-degree N has 0 indegree


      Algorithm
       Crete adjaceny list
       Map<Vertex,List<edges>>
       Array to keep track of indegrees
       int[] degrees = int[n]
       iterat over list of edges
        for(int[] p:pre){
            Create List for each vertex

        }
    */
}
