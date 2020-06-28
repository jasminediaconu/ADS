package practice.TopologicalSorting;

public class Edge {
    private Vertex a;
    private Vertex b;

    public Edge(Vertex a, Vertex b) {
        this.a = a;
        this.b = b;
    }

    public Vertex getIncomingVertex() {
        return a;
    }

    public Vertex getOutgoingVertex() {
        return b;
    }

    @Override
    public String toString() {
        return "<Edge: " + a.getId() + ", " + b.getId() + ">";
    }
}
