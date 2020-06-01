package exam.FinalA.Graph;

import java.util.ArrayList;
import java.util.Stack;

public class CountVertices {
    /**
     * Counts the number of vertices in the same connected component as v in graph g.
     * This is done using depth first search.
     * <p>
     * Returns 0 if the graph or vertex is null
     *
     * @param g The graph to count vertices in.
     * @param v The vertex to start counting at.
     * @return the number of vertices in the same connected component.
     */
    public static int countVertices(Graph g, Graph.Vertex v) {
        if (g == null || v == null) return 0;

        Stack<Graph.Vertex> dfs = new Stack<>();
        ArrayList<Graph.Vertex> visited = new ArrayList<>();
        int count = 0;
        dfs.push(v);

        while (!dfs.isEmpty()) {
            Graph.Vertex v1 = dfs.pop();
            visited.add(v1);

            for (Graph.Vertex v2 : v1.getNeighbours()) {
                if (!visited.contains(v2))
                    dfs.push(v2);
            }

            count++;
        }

        return count;
    }
}
