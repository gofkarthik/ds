package ds.graph.problems;

import ds.graph.problems.util.GraphNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
  Create queue
  Place parent node in q
  print / mark it as visited (critical else in undirected this also an edge
  getNeigbors
  Iterate neigbors
    if(neigbors not visited)
    addQueue
    markItVisited
 */
public class BFSBasics {

    int[][] graph = new int[11][11];

    List<GraphNode> graphNodeList = new ArrayList<>();

    void bfs() {
        for (GraphNode graphNode : graphNodeList) {
            if (!graphNode.isVisited) {
                bfs(graphNode);
            }
        }
    }

    void bfs(GraphNode graphNode) {
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(graphNode);
        while (!queue.isEmpty()) {
            GraphNode node = queue.poll();
            node.isVisited = true;
            System.out.print(node.vertex + " ");
            List<GraphNode> neighbors = getNeighbors(node);
            for (GraphNode neighbor : neighbors) {
                if (!neighbor.isVisited) {
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }

    }

    //https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
    /*
    ArrayList<ArrayList<Integer>> list: represent graph containing vertices
                                    and edges between them
      vis[]: boolean array to represent visited vertex
        s: starting vertex
     */
    static void bfs(int s, ArrayList<ArrayList<Integer>>
            list, boolean vis[], int nov){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(s);
        while(!queue.isEmpty()){
          Integer vertex=queue.poll();
          vis[vertex] = true;
          System.out.print(vertex+" ");
          ArrayList<Integer> neighbors=list.get(vertex);
          for(Integer i:neighbors){
              if(!vis[i]){
                  queue.add(i);
                  vis[i]=true;
              }
          }
        }
    }

    public void addUndirectedEdge(int i, int j) {
        i=i-1;
        j=j-1;
        graph[i][j] = 1;
        graph[j][i] = 1;
    }

    public List<GraphNode> getNeighbors(GraphNode graphNode) {
        //iterate over rows
        //for that row check its neighbor in column value
        List<GraphNode> neighbors = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (graph[i][graphNode.index] == 1) {
                neighbors.add(graphNodeList.get(i));
            }
        }
        return neighbors;
    }

    public static void main(String[] args) {

        BFSBasics graph = new BFSBasics();
        //add vertices
        for (int i = 1; i < 8; i++) {
            graph.graphNodeList.add(new GraphNode("V" + i, i - 1));
        }
        //add edges
        graph.addUndirectedEdge(1, 2);
        graph.addUndirectedEdge(1, 3);
        graph.addUndirectedEdge(2, 4);
        graph.addUndirectedEdge(2, 5);
        graph.addUndirectedEdge(3, 6);
        graph.addUndirectedEdge(4, 7);
        graph.addUndirectedEdge(2, 5);
        graph.addUndirectedEdge(5, 7);

        graph.bfs();
    }
}
