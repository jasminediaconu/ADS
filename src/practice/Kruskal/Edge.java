package practice.Kruskal;

public class Edge implements Comparable<Edge> {
    private Vertex a;
    private Vertex b;
    private int weight;

    public Edge(Vertex a, Vertex b, int weight) {
        this.a = a;
        this.b = b;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public Vertex getIncomingVertex() {
        return a;
    }

    public Vertex getOutgoingVertex() {
        return b;
    }

    @Override
    public String toString() {
        return "<Edge: " + a.getId() + ", " + b.getId() + ", weight: " + weight + ">";
    }

    @Override
    public int compareTo(Edge o) {
        return this.getWeight() - o.getWeight();
    }

    @Override
    public int hashCode() {
        return this.getWeight();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Edge && ((Edge) o).getWeight() == this.getWeight();
    }

}
