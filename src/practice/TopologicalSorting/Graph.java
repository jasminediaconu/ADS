package practice.TopologicalSorting;

import java.util.*;

public class Graph {

    private Map<Integer, Vertex> vertices = new HashMap<>();
    private ArrayList<Edge> edges = new ArrayList<Edge>();

    /**
     * Creates a new graph with n vertices.
     *
     * @param n Amount of vertices in the graph.
     */
    public Graph(int n) {
        for (int i = 0; i < n; i++) vertices.put(i, new Vertex(i));
    }

    /**
     * Returns the vertex with the given ID.
     *
     * @param id The ID for the vertex to get.
     * @return The vertex with the given ID.
     * @throws IllegalArgumentException if no vertex with the given ID is in the graph.
     */
    public Vertex getVertex(int id) throws IllegalArgumentException {
        if (!vertices.containsKey(id))
            throw new IllegalArgumentException("Vertex not in graph");
        return vertices.get(id);
    }

    public Collection<Vertex> getAllVertices() {
        return new ArrayList<>(this.vertices.values());
    }

    public Collection<Edge> getAllEdges() {
        return new ArrayList<>(this.edges);
    }

    /**
     * Returns all neighbours of the given vertex sorted by their ID.
     *
     * @param v The vertex to get the neighbours from.
     * @return A sorted list of all neighbouring vertices.
     */
    public List<Vertex> getNeighbours(Vertex v) {
        List<Vertex> neighbours = new ArrayList<>(v.getNeighbours());
        neighbours.sort(Comparator.comparingInt(a -> a.getId()));
        return neighbours;
    }

    /**
     * Adds an edge between vertex u and v with the given weight.
     *
     * @param u      First vertex.
     * @param v      Second vertex.
     */
    public void addEdge(Vertex u, Vertex v) {
        u.addNeighbour(v);
        v.addNeighbour(u);
        edges.add(new Edge(u, v));
    }

    /**
     * Adds an edge between the vertices with IDs u and v with the given weight.
     *
     * @param u      ID of the first vertex.
     * @param v      ID of the second vertex.
     * @throws IllegalArgumentException if no vertex with the given ID is in the graph.
     */
    public void addEdge(int u, int v) throws IllegalArgumentException {
        addEdge(new Vertex(u), new Vertex(v));
    }

    /**
     * Get inDegree of Vertex.
     */
    public int inDegree(Vertex v) {
        return incomingEdges(v).size();
    }

    /**
     * Get outDegree of Vertex.
     */
    public int outDegree(Vertex v) {
        return outgoingEdges(v).size();
    }

    /**
     * Get outgoing vertices of a Vertex
     * @param v
     * @return
     */
    public ArrayList<Edge> outgoingEdges(Vertex v) {
        ArrayList<Edge> edges = new ArrayList<>();

        for(Edge e : getAllEdges()) {
            if(e.getIncomingVertex().equals(v)) edges.add(e);

        }
       return edges;
    }

    /**
     * Get incoming vertices of a Vertex
     * @param v
     * @return
     */
    public ArrayList<Edge> incomingEdges(Vertex v) {
        ArrayList<Edge> edges = new ArrayList<>();

        for(Edge e : getAllEdges()) {
            if(e.getOutgoingVertex().equals(v)) edges.add(e);

        }
        return edges;
    }
}