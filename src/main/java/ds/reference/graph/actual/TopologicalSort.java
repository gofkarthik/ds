package ds.reference.graph.actual;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import ds.reference.graph.actual.node.GraphNode;

public class TopologicalSort {
	ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

	
	//Constructor
	public TopologicalSort(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
	}

	
	void topologicalSort() {
		Stack<GraphNode>stack = new Stack<>();
		for (GraphNode node : nodeList) { // if a node is unvisited then run topologicalSort on it
			if (!node.isVisited())
				topologicalVisit(node,stack);
		}
		while(!stack.isEmpty()){
			System.out.print(stack.pop().getName()+" ");
		}
	}

	
	// Topological visit by a source node
	@Deprecated
	void topologicalVisit(GraphNode node, Stack<GraphNode> stack) {
		for (GraphNode neighbor : node.getNeighbors()){	//if neighbor is not visited then recursive call to it
			if(!neighbor.isVisited()){
				topologicalVisit(neighbor,stack);
			}
		}
		node.setVisited(true);
		stack.push(node);
	} // end of method

	
	// add a directed edge between two nodes
	public void addDirectedEdge(int i, int j) {
		GraphNode first = nodeList.get(i - 1);
		GraphNode second = nodeList.get(j - 1);
		first.getNeighbors().add(second);
	} // end of method

	public static void main(String[] args) {
		List<Integer> aa=new ArrayList<>();
		aa.toArray(new Integer[0]);
	}
}//end of class