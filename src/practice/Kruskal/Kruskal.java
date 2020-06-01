package practice.Kruskal;

import java.util.*;

public class Kruskal {
    /**
     * Returns the length of the shortest spanning tree with the Union-Find Algorithm.
     *
     * @param g Graph to consider.
     * @return The length of the shortest path or -1 if no such path exists.
     */
    public static int shortestPath(Graph g) {
        if(g == null) return -1;

        // Get all edges and sort them in ascendant order
        ArrayList<Edge> edges = g.getAllEdges();
        Collections.sort(edges);

        Queue<Edge> queue = new LinkedList<>();

        for (Edge e: edges) {
            queue.add(e);
        }

        // The max allowed number of edges
        int finalCount = g.getAllVertices().size() - 1;
        // The initial number of edges
        int initCount = 0;
        // Weight of the minimum spanning tree
        int result = 0;

        DisjointSet disjointSet = new DisjointSet(g.getAllVertices());

        while(!queue.isEmpty()) {
            Edge e = queue.remove();

            if(initCount == finalCount) return result;

            if(!hasCycle(e.getIncomingVertex(), e.getOutgoingVertex(), disjointSet)) {
                initCount++;
                System.out.println(e.toString());
                result += e.getWeight();
            }
        }

        return -1;
    }

    public static boolean hasCycle(Vertex source, Vertex destination, DisjointSet disjointSet) {
        Vertex root = disjointSet.find(source);
        Vertex root2 = disjointSet.find(destination);

        if(root == root2) return true;

        else disjointSet.union(source, destination);

        return false;
    }
}
