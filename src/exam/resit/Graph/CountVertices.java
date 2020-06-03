package exam.resit.Graph;

import java.util.*;

public class CountVertices {
    /**
     * @param g The graph to search in.
     * @param v The vertex to start searching from.
     * @param n The number of edges n that can be traversed from v.
     * @return The number of vertices that are reachable from v (including v), using at most n edges.
     */
    public static int countVertices(Graph g, Vertex v, int n) {
        if (n == 0) return 1;

        Queue<Vertex> queue = new LinkedList();

        queue.add(v);

        // number of edges will always be V - 1, with HashMap we can start from 0 to add vertices.
        Map<Vertex, Integer> visited = new HashMap();

        visited.put(v, 0);

        while (!queue.isEmpty()) {

            Vertex u = queue.poll();

            for (Vertex v1 : g.getNeighbours(u)) {
                if (visited.get(u) < n && !queue.contains(v1)) {
                    queue.add(v1);
                    visited.put(v1, visited.get(u) + 1);
                }
            }
        }
        return visited.size();
    }
}
