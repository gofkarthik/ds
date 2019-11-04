package ds.graph.problems;


/**
 * Runtime Complexity - O(V+E)
 * Space Complexity - O(V+E)
 *
 * Sorts given actions in such a way,if there is a dependency of one action on other,then
 * the dependent action always comes later that its parent action
 *
 *         A     E
 *         | /   |
 *         >     >
 *         C     D
 *
 * C can be done only after  A and E
 * D can be done only after E
 * AECD
 *
 * Algo dry run:
 * =============
 * Use stack
 * If(some other vertex is dependent on currentVertex)
 *  then go to that Vertex first and then come back to this vertex
 * else push currentVert in stack
 *
 *  topologialSort(G)
 *      for all nodes
 *          if vertex not visited
 *              topologicalVisit(v)
 *  topologicalVisit(V)
 *      for each neighbor of V
 *          if neigborNotVisited
 *              topologicalVisit(V)
 *   mark node visited and push it to stack
 *
 *   // Why must a graph with a topological sort be acyclic and why must an acyclic
 *       graph have a topological sort?
 *   a graph is cyclic, then you have some cycle with, say, vertices A->B->C->A->B->C->A... Then,
 *   if you arrive at A before B or C, you won't have satisfied the sort property
 *   (because B and C will not have been visited). If you arrive, instead,
 *   at B before A or C, you also won't have satisfied the sort property.
 *   And, if you arrive at C... well, you know. With a directed cycle,
 *   no matter which point in the cycle you arrive at first, there is no possible way to satisfy the
 *   topological sort.
 *
 *   A topological sort must be acyclic and directed
 */
public class TopologialSort {


}
