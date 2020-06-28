package practice.Graph;

import java.util.*;

/**
 * Implement the method int countVertices(Graph g, Vertex v, int n),
 * which uses depth-first search to compute the number of vertices
 * that can be reached from vertex v via at most n edges in an undirected graph g.
 * The vertex v itself should be included in this count.
 *
 * You do not have to consider the case where any of the input parameters is null.
 */
public class GraphImpl implements Graph {
    private Map<Integer, Vertex> vertices;

    public GraphImpl() {
        this.vertices = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        this.vertices.put(v.getId(), v);
    }

    @Override
    public Collection<Vertex> getAllVertices() {
        return new ArrayList<>(this.vertices.values());
    }

    @Override
    public List<Vertex> getNeighbours(Vertex v) {
        List<Vertex> neigh = new ArrayList<>(((VertexImpl) v).getNeighbours());
        Collections.sort(neigh);
        return neigh;
    }

    public void addEdge(Vertex v, Vertex w) {
        VertexImpl realV = (VertexImpl) v;
        VertexImpl realW = (VertexImpl) w;
        realV.addNeighbour(w);
        realW.addNeighbour(v);
    }
}
