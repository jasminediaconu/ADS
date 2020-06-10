package exam.Dijkstra;

import java.util.Collection;
import java.util.Iterator;

public class DijkstraShortestPath {

    /**
     * Returns the length of the shortest path between vertex a and b in graph g.
     *
     * @param g exam.Dijkstra.Graph to consider.
     * @param a exam.Dijkstra.Vertex to start from.
     * @param b exam.Dijkstra.Vertex to go to.
     * @return The length of the shortest path between a and b, or -1 if no such path exists.
     */
    public static int shortestPath(Graph g, Vertex a, Vertex b) {
        if (a == b) return 0;
        // Get all the vertices
        Collection<Vertex> vertices = g.getAllVertices();

        Iterator iterator = vertices.iterator();
        int[] dist = new int[vertices.size()];
        AdaptablePQ pq = new AdaptablePQ();

        for (int i = 0; i < dist.length; i++) dist[i] = Integer.MAX_VALUE;
        dist[a.getId()] = 0;

        while (iterator.hasNext()) {
            Vertex v = (Vertex) iterator.next();
            if (v == a) pq.insertOrReplace(v, 0);
            iterator.remove();
        }

        return findShortest(pq, a, b, dist);
    }

    public static int findShortest(AdaptablePQ pq, Vertex a, Vertex b, int[] dist) {
        while (!pq.isEmpty()) {
            VertexNumPair v = pq.removeMin();

            if (v.getVertex() == b) return v.getNum();

            System.out.println(v.getNum());
            Collection<VertexNumPair> neighbours = v.getVertex().getNeighbours();

            for (VertexNumPair v1 : neighbours) {
                int currShort = v.getNum() + v1.getNum();
                if (currShort < dist[v1.getVertex().getId()]) {
                    pq.insertOrReplace(v1.getVertex(), currShort);
                    dist[v1.getVertex().getId()] = currShort;
                }
            }
        }

        return -1;
    }
}
