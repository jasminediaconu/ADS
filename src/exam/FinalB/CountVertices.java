package exam.FinalB;

import exam.FinalA.Graph.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CountVertices {
    /**
     * Counts the number of vertices in the same connected component as v in graph g.
     * This is done using breadth first search.
     * <p>
     * Returns 0 if the graph or vertex is null
     *
     * @param g The graph to count vertices in.
     * @param v The vertex to start counting at.
     * @return the number of vertices in the same connected component.
     */
    public static int countVertices(Graph g, Graph.Vertex v) {
        if (g == null || v == null) return 0;

        Queue<Graph.Vertex> bfs = new LinkedList<>();
        ArrayList<Graph.Vertex> visited = new ArrayList<>();

        int count = 1;
        bfs.add(v);
        visited.add(v);

        while (!bfs.isEmpty()) {
            Graph.Vertex v1 = bfs.poll();

            for (Graph.Vertex v2 : g.getNeighbours(v1)) {
                if (!visited.contains(v2)) {
                    visited.add(v2);
                    bfs.add(v2);
                    count++;
                }
            }
        }

        return count;
    }
}
