package ds_ref.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {

    String vertex;

    boolean isVisited;

    int index;

    List<GraphNode> neighbors=new ArrayList<>();

    GraphNode(String vertex,int index){
        this.vertex=vertex;
        this.index=index;
    }

}
