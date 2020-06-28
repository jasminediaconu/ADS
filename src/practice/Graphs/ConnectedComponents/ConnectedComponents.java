package practice.Graphs.ConnectedComponents;

import practice.Graphs.ShortestPath.Graph;

public class ConnectedComponents {
    /**
     *  Implement the method numberOfConnectedComponents(g)
     *  which returns the number of connected components in an undirected graph g.
     *
     *  The following two interfaces are provided, which have full implementations in the hidden library code.
     *
     * The library code also has a full implementation of the iterator from the first assignment.
     * This iterator can be instantiated using new GraphIterator(Graph g, Vertex v).
     * Furthermore, note that the iterator implements the Iterator<Vertex> interface,
     * whose description can be found in the Java API documentation.
     *
     * IMPORTANT: You are required to use the GraphIterator in your solution.
     * In an exam setting, your code will be checked and if it is seen that you do not use it,
     * your grade will be overridden to 1.
     *
     * Again, you cannot label nodes or edges.
     * Instead, you need to maintain the unexplored nodes in a collection unexplored,
     * which can be initialized with g.getAllVertices().
     * To remove an explored node v from unexplored, you call unexplored.remove(v).
     * To get the next unexplored node, you call unexplored.iterator().next().
     *
     * NOTE: You cannot iterate over the elements from unexplored with a for loop i.e.
     * for(Vertex v: unexplored) will not work, since you need to be able to remove element from unexplored.
     */
    public static int numberOfConnectedComponents(Graph g) {
        // TODO

        return 0;
    }
}
