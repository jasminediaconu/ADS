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

        Comparator<Edge> comparator = new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                if(o1.getWeight() < o2.getWeight()) return -1;
                if(o1.getWeight() > o2.getWeight()) return 1;

                return 0;
            }
        };
        
        // Get all edges and sort them in ascendant order
        Queue<Edge> pq = new PriorityQueue<>(g.getAllEdges().size(), comparator);

        for (Edge e: g.getAllEdges()) {
            pq.add(e);
        }

        // The max allowed number of edges
        int finalCount = g.getAllVertices().size() - 1;
        // The initial number of edges
        int initCount = 0;
        // Weight of the minimum spanning tree
        int result = 0;

        DisjointSet disjointSet = new DisjointSet(g.getAllVertices());

        while(!pq.isEmpty()) {
            Edge e = pq.remove();

            if(initCount == finalCount) return result;

            if(!hasCycle(e.getIncomingVertex(), e.getOutgoingVertex(), disjointSet)) {
                initCount++;
                System.out.println(e.toString());
                result += e.getWeight();
            }
        }

        return result;
    }

    public static boolean hasCycle(Vertex source, Vertex destination, DisjointSet disjointSet) {
        Vertex root = disjointSet.find(source);
        Vertex root2 = disjointSet.find(destination);

        if(root == root2) return true;

        else disjointSet.union(source, destination);

        return false;
    }
}
