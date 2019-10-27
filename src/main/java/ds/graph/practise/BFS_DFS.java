package ds.graph.practise;


import java.util.*;

public class BFS_DFS {

    List<GraphNode> graphNodes = new ArrayList();

    int [][] adjacenyMatrix;

    BFS_DFS(int size){
        adjacenyMatrix = new int[size][size];
    }

    void addVertex(){
        for (int i = 1; i <=10; i++) {
            graphNodes.add(new GraphNode("V"+i,i-1));
        }
    }

    void addUndirectedEdge(){
        addInMatrix(1,2);
        addInMatrix(1,4);
        addInMatrix(2,3);
        addInMatrix(2,5);
        addInMatrix(3,6);
        addInMatrix(3,10);
        addInMatrix(4,7);
        addInMatrix(5,8);
        addInMatrix(6,9);
        addInMatrix(7,8);
        addInMatrix(8,9);
        addInMatrix(9,10);
    }

    void addUndirectedEdgeList(){
        addInAdjaceny(1,2);
        addInAdjaceny(1,4);
        addInAdjaceny(2,3);
        addInAdjaceny(2,5);
        addInAdjaceny(3,6);
        addInAdjaceny(3,10);
        addInAdjaceny(4,7);
        addInAdjaceny(5,8);
        addInAdjaceny(6,9);
        addInAdjaceny(7,8);
        addInAdjaceny(8,9);
        addInAdjaceny(9,10);
    }
    void addInMatrix(int i,int j){
        i=i-1;
        j=j-1;
        adjacenyMatrix[i][j]=1;
        adjacenyMatrix[j][i]=1;
    }

    void addInAdjaceny(int i,int j){
        i=i-1;
        j=j-1;
        graphNodes.get(i).neighbors.add(graphNodes.get(j));
        graphNodes.get(j).neighbors.add(graphNodes.get(i));
    }
    
    void bfsAdjacenyMatrix(){
        for (GraphNode graphNode : graphNodes) {
            if(!graphNode.isVisited){
                Queue<GraphNode> graphNodeQueue=new LinkedList<>();
                graphNodeQueue.add(graphNode);
                while (!graphNodeQueue.isEmpty()){
                    GraphNode graphNodeElement = graphNodeQueue.remove();
                    System.out.print(graphNodeElement.vertex +" ");
                    graphNodeElement.isVisited=true;
                    ArrayList<GraphNode> adjacenyNeighbors = getAdjacenyNeighbors(graphNodeElement);
                    for (GraphNode adjacenyNeighbor : adjacenyNeighbors) {
                        if(!adjacenyNeighbor.isVisited) {
                            graphNodeQueue.add(adjacenyNeighbor);
                            adjacenyNeighbor.isVisited = true;
                        }
                    }
                }
            }
        }
    }

    void bfsAdjacenyList(){
        for (GraphNode graphNode : graphNodes) {
            if(!graphNode.isVisited){
                Queue<GraphNode> graphNodeQueue=new LinkedList<>();
                graphNodeQueue.add(graphNode);
                while (!graphNodeQueue.isEmpty()){
                    GraphNode graphNodeElement = graphNodeQueue.remove();
                    System.out.print(graphNodeElement.vertex +" ");
                    graphNodeElement.isVisited=true;
                    for (GraphNode neighbor : graphNodeElement.neighbors) {
                        if(!neighbor.isVisited){
                            graphNodeQueue.add(neighbor);
                            neighbor.isVisited=true;
                        }
                    }
                }
            }
        }
    }

    ArrayList<GraphNode> getAdjacenyNeighbors(GraphNode graphNode){
        int index = graphNode.index;
        ArrayList<GraphNode> neighbors=new ArrayList<>();
        for (int i = 0; i < adjacenyMatrix.length; i++) {
             if(adjacenyMatrix[index][i]==1){
                neighbors.add(graphNodes.get(i));
                 //System.out.println(graphNode.vertex + " neighbor "+graphNodes.get(i).vertex);
             }
        }
        return neighbors;
    }

    void printMatrix(){
        for (int i = 0; i < adjacenyMatrix.length; i++) {
            int[] matrix = adjacenyMatrix[i];
            for (int j = 0; j < matrix.length; j++) {
                if(adjacenyMatrix[i][j] == 1) {
                    System.out.println(i + " " + j);
                }

            }
        }
    }

    void dfs(boolean isIterative){
        for (GraphNode graphNode : graphNodes) {
            if(isIterative && !graphNode.isVisited){
                dfsIterative(graphNode);
            }else if(!graphNode.isVisited) {
                dfsRecursive(graphNode);
            }
        }

    }


    void dfsIterative(GraphNode graphNode){
        Stack<GraphNode> stack=new Stack<>();
        stack.push(graphNode);
        while(!stack.empty()){
            GraphNode node = stack.pop();
            node.isVisited=true;
            System.out.print(node.vertex +" ");
            for (GraphNode neighbor : node.neighbors) {
                if(!neighbor.isVisited){
                  //  System.out.println(node + " " + neighbor);
                    stack.push(neighbor);
                    neighbor.isVisited=true;
                }
            }
        }
    }

    void dfsRecursive(GraphNode node){
        node.isVisited=true;
        System.out.print(node.vertex +" ");
        for (GraphNode graphNode : node.neighbors) {
            if(!graphNode.isVisited){
                dfsRecursive(graphNode);
            }
        }
    }

    public static void main(String[] args) {
        BFS_DFS bfs_dfs= new BFS_DFS(10);
        bfs_dfs.addVertex();
       // bfs.addUndirectedEdge();
      //  bfs.printMatrix();
       // bfs.bfsAdjacenyMatrix();
        bfs_dfs.addUndirectedEdgeList();
        //bfs_dfs.bfsAdjacenyList();
       // bfs_dfs.dfs(true);
        bfs_dfs.dfs(false);
    }
}
