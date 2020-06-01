package practice.Kruskal;

/**
 * Container class used to store a exam.Dijkstra.Vertex and an int.
 */
public class VertexNumPair {

    private Vertex vertex;

    private int num;

    public VertexNumPair(Vertex vertex, int num) {
        this.vertex = vertex;
        this.num = num;
    }

    public Vertex getVertex() {
        return vertex;
    }

    public int getNum() {
        return num;
    }
}