package ds_ref.graph.practise;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphBFSDFS {

    List<GraphNode> gn = new ArrayList<>();

    int[][] gnMatrix = new int[11][11];

    void populateVertexes(String vertex, int index) {
        gn.add(new GraphNode(vertex, index));
    }

    void dfs(){
        for(GraphNode gNode:gn){
            if(!gNode.isVisited){
                dfsVisit(gNode);
            }
        }
    }

    void dfsVisit(GraphNode graphNode){
        graphNode.isVisited=true;
        System.out.print(graphNode.vertex + " ");
        for(GraphNode gn:graphNode.neighbors){
            if(!gn.isVisited) {
                dfsVisit(gn);
            }
        }
    }

    void bfs(){
        for(GraphNode gNode:gn){
           if(!gNode.isVisited){
               bfsVisit(gNode);
           }
        }
    }

    List<GraphNode> getNeighbors(int vertex){
        List<GraphNode> neighbors=new ArrayList<>();
        for(int i=0;i<gnMatrix.length;i++){
            if(gnMatrix[vertex][i] == 1){
                neighbors.add(gn.get(i));
            }
        }
        return neighbors;
    }

    void bfsVisit(GraphNode graphNode){
        Queue<GraphNode> queue=new LinkedList<>();
        queue.add(graphNode);
        while(!queue.isEmpty()){
            GraphNode gNN = queue.poll();
            System.out.print(gNN.vertex+" ");
            gNN.isVisited=true;
           // List<GraphNode> neighbors = getNeighbors(gNN.index);
            List<GraphNode> neighbors = gNN.neighbors;
            for(GraphNode g:neighbors){
                if(!g.isVisited) {
                    g.isVisited=true;
                    queue.add(g);
                }
            }
        }
    }


    private void addUndirectedEdge(int v1,int v2){
        v1--;
        v2--;
        //For matrix
        //gnMatrix[v1][v2]=1;
        //gnMatrix[v2][v1]=1;
        gn.get(v1).neighbors.add(gn.get(v2));
        gn.get(v2).neighbors.add(gn.get(v1));
    }
    public static void main(String[] args) {
        GraphBFSDFS graph = new GraphBFSDFS();
        for (int i = 1; i < 11; i++) {
            graph.populateVertexes("V" + (i), i-1);

        }
        graph.addUndirectedEdge(1,2);
        graph.addUndirectedEdge(1,4);
        graph.addUndirectedEdge(2,3);
        graph.addUndirectedEdge(2,5);
        graph.addUndirectedEdge(3,6);
        graph.addUndirectedEdge(3,10);
        graph.addUndirectedEdge(4,7);
        graph.addUndirectedEdge(5,8);
        graph.addUndirectedEdge(6,9);
        graph.addUndirectedEdge(7,8);
        graph.addUndirectedEdge(8,9);
        graph.addUndirectedEdge(9,10);
       // graph.bfs();
        graph.dfs();
    }
}
