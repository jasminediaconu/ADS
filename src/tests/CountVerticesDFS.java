package tests;

import exam.FinalA.CountVertices;
import exam.FinalA.Graph;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountVerticesDFS {
    @Test
    public void testNull() {
        Graph g = new Graph();
        Graph.Vertex v = null;
        assertEquals(0, CountVertices.countVertices(g, v));
        g = null;
        v = new Graph.Vertex(1);
        assertEquals(0, CountVertices.countVertices(g, v));
    }

    @Test
    public void testExample() {
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
        assertEquals(3, CountVertices.countVertices(g, v));
        assertEquals(3, CountVertices.countVertices(g, w));
        assertEquals(3, CountVertices.countVertices(g, y));
        assertEquals(1, CountVertices.countVertices(g, x));
    }

    @Test
    public void testNull2() {
        Graph g = new Graph();
        Graph.Vertex v = null;
        assertEquals(0, exam.FinalB.CountVertices.countVertices(g, v));
        g = null;
        v = new Graph.Vertex(1);
        assertEquals(0, exam.FinalB.CountVertices.countVertices(g, v));
    }

    @Test
    public void testExample2() {
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
