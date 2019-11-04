package ds.reference.graph.practise;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {

     String vertex;

     int index;

     boolean isVisited;

     List<GraphNode> neighbors=new ArrayList<>();

     GraphNode(String vertex,int index){
         this.vertex=vertex;
         this.index=index;
     }
}
