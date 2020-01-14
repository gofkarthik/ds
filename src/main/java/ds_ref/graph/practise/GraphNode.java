package ds_ref.graph.practise;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {

    String vertex;

    boolean isVisited;

    int index;

    List<GraphNode> neighbors=new ArrayList<>();

    GraphNode(String vertex){

    }
    GraphNode(String vertex, int index){
        this.vertex=vertex;
        this.index=index;
    }



}
