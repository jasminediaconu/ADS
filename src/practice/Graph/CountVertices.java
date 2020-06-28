package practice.Graph;

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

        Stack<Vertex> stack = new Stack<>();

        stack.push(v);

        // number of edges will always be V - 1, with HashMap we can start from 0 to add vertices.
        Map<Vertex, Integer> visited = new HashMap();

        visited.put(v, 0);

        while (!stack.isEmpty()) {

            Vertex u = stack.pop();

            for (Vertex v1 : g.getNeighbours(u)) {
                if (visited.get(u) < n && !stack.contains(v1)) {
                    stack.add(v1);
                    visited.put(v1, visited.get(u) + 1);
                }
            }
        }
        return visited.size();
    }
}
