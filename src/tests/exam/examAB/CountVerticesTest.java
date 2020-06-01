package exam.examAB;

import exam.FinalA.Graph.Graph;
import exam.FinalA.Graph.CountVertices;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountVerticesTest {
    @Test
    public void testNullA() {
        Graph g = new Graph();
        Graph.Vertex v = null;
        Assertions.assertEquals(0, CountVertices.countVertices(g, v));
        g = null;
        v = new Graph.Vertex(1);
        Assertions.assertEquals(0, CountVertices.countVertices(g, v));
    }

    @Test
    public void testExampleA() {
        Graph g = new Graph();
        Graph.Vertex v = new Graph.Vertex(1);
        Graph.Vertex w = new Graph.Vertex(2);
        Graph.Vertex x = new Graph.Vertex(3);
        Graph.Vertex y = new Graph.Vertex(4);
        g.addVertex(v);
        g.addVertex(w);
        g.addVertex(x);
        g.addVertex(y);
        g.addEdge(v, w);
        g.addEdge(w, y);
        Assertions.assertEquals(3, CountVertices.countVertices(g, v));
        Assertions.assertEquals(3, CountVertices.countVertices(g, w));
        Assertions.assertEquals(3, CountVertices.countVertices(g, y));
        Assertions.assertEquals(1, CountVertices.countVertices(g, x));
    }

    @Test
    public void testNullB() {
        Graph g = new Graph();
        Graph.Vertex v = null;
        assertEquals(0, exam.FinalB.CountVertices.countVertices(g, v));
        g = null;
        v = new Graph.Vertex(1);
        assertEquals(0, exam.FinalB.CountVertices.countVertices(g, v));
    }

    @Test
    public void testExampleB() {
        Graph g = new Graph();
        Graph.Vertex v = new Graph.Vertex(1);
        Graph.Vertex w = new Graph.Vertex(2);
        Graph.Vertex x = new Graph.Vertex(3);
        Graph.Vertex y = new Graph.Vertex(4);
        g.addVertex(v);
        g.addVertex(w);
        g.addVertex(x);
        g.addVertex(y);
        g.addEdge(v, w);
        g.addEdge(w, y);
        assertEquals(3, exam.FinalB.CountVertices.countVertices(g, v));
        assertEquals(3, exam.FinalB.CountVertices.countVertices(g, w));
        assertEquals(3, exam.FinalB.CountVertices.countVertices(g, y));
        assertEquals(1, exam.FinalB.CountVertices.countVertices(g, x));
    }
}
