package ds.graph.problems.util;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {

    public String vertex;

    public boolean isVisited;

    public int index;

    public GraphNode() {

    }

    public GraphNode(String vertex, int index) {
        this.vertex = vertex;
        this.index = index;
    }


}
