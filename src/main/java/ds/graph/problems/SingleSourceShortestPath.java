package ds.graph.problems;


import ds.graph.problems.util.GraphNode;

import java.util.ArrayList;
import java.util.LinkedList;

class PathFindingByBFS {
    ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();


    //Constructor
    public PathFindingByBFS(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }//end of method


    //Print path of each of the vertex from source
    public static void pathPrint(GraphNode node) {
        if (node.parent != null)
            pathPrint(node.parent);  //recursive call to parent
        System.out.print(node.vertex + " ");
    }//end of method


    //BFS Traversal by a source node
    void BFSForSSSP(GraphNode node) {
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);  //add source node to queue
        while (!queue.isEmpty()) {
            GraphNode presentNode = queue.remove(0);
            presentNode.isVisited = true;
            System.out.print("Printing path for node " + presentNode.vertex + ": ");
            pathPrint(presentNode);
            System.out.println();
            for (GraphNode neighbor : presentNode.neighbors) {  //for each neighbor of present node
                if (!neighbor.isVisited) {
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                    neighbor.parent = presentNode;
                }//end of if
            }//end of for loop
        }//end of while loop
    }//end of method


    // add an undirected edge between two nodes
    public void addUndirectedEdge(int i, int j) {
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);
        first.neighbors.add(second);
        second.neighbors.add(first);
    }//end of method

}//end of class

public class SingleSourceShortestPath {

    public static void main(String[] args) {

        ArrayList<GraphNode> nodeList = new ArrayList<>();
        for(int i=0;i<10; i++) {
            nodeList.add(new GraphNode(""+i));
        }
        PathFindingByBFS graph = new PathFindingByBFS(nodeList);
        //add edges following graph in graph.docx
        graph.addUndirectedEdge(0,8);
        graph.addUndirectedEdge(8,2);
        graph.addUndirectedEdge(8,9);
        graph.addUndirectedEdge(2,1);
        graph.addUndirectedEdge(9,1);
        graph.addUndirectedEdge(2,4);
        graph.addUndirectedEdge(1,3);
        graph.addUndirectedEdge(1,7);
        graph.addUndirectedEdge(3,4);
        graph.addUndirectedEdge(3,5);
        graph.addUndirectedEdge(7,6);
        graph.addUndirectedEdge(5,6);

        System.out.println("Printing BFS from source: 2");
        graph.BFSForSSSP(nodeList.get(2));

    }

}
