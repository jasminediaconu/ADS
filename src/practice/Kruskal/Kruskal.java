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
        if (g == null) return -1;

        Comparator<Edge> comparator = new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                if (o1.getWeight() < o2.getWeight()) return -1;
                if (o1.getWeight() > o2.getWeight()) return 1;

                return 0;
            }
        };

        // Get all edges and sort them in ascendant order
        Queue<Edge> pq = new PriorityQueue<>(g.getAllEdges().size(), comparator);

        for (Edge e : g.getAllEdges()) {
            pq.add(e);
        }

        // The max allowed number of edges
        int finalCount = g.getAllVertices().size() - 1;
        // The initial number of edges
        int initCount = 0;
        // Weight of the minimum spanning tree
        int result = 0;

        HashMap<Vertex, Vertex> disjointSet = new HashMap<Vertex, Vertex>();

        for (Vertex v : g.getAllVertices())
            disjointSet.put(v, v);

        while (initCount != finalCount && !pq.isEmpty()) {
            Edge e = pq.remove();

            if (!hasCycle(e.getIncomingVertex(), e.getOutgoingVertex(), disjointSet)) {
                initCount++;
                System.out.println(e.toString());
                result += e.getWeight();
            }
        }

        return result;
    }

    /**
     * Checks if the graph has cycles.
     * @param source
     * @param destination
     * @param disjointSet
     * @return
     */
    public static boolean hasCycle(Vertex source, Vertex destination, HashMap<Vertex, Vertex> disjointSet) {
        Vertex root = find(disjointSet, source);
        Vertex root2 = find(disjointSet, destination);

        if (root == root2) return true;

        else union(disjointSet, source, destination);

        return false;
    }

    public static Vertex find(HashMap<Vertex, Vertex> parent, Vertex v) {
        // Vertex is the root
        if (parent.get(v) == v) return v;

        // recursive call
        return find(parent, parent.get(v));
    }

    public static void union(HashMap<Vertex, Vertex> parent, Vertex a, Vertex b) {
        Vertex x = find(parent, a);
        Vertex y = find(parent, b);

        parent.put(x, y);
    }
}
