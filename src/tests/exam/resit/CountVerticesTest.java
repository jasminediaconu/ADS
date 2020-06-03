package exam.resit;

import exam.resit.Graph.CountVertices;
import exam.resit.Graph.GraphImpl;
import exam.resit.Graph.Vertex;
import exam.resit.Graph.VertexImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountVerticesTest {
    @Test
    public void testSingleLoopingVertex() {
        GraphImpl g = new GraphImpl();
        Vertex v = new VertexImpl(0);
        g.addVertex(v);
        g.addEdge(v, v);
        assertEquals(1, CountVertices.countVertices(g, v, 0));
        assertEquals(1, CountVertices.countVertices(g, v, 1));
        assertEquals(1, CountVertices.countVertices(g, v, 2));
    }

    @Test
    public void testDoubleVertex() {
        GraphImpl g = new GraphImpl();
        Vertex v = new VertexImpl(0);
        Vertex w = new VertexImpl(1);
        g.addVertex(v);
        g.addVertex(w);
        g.addEdge(v, w);
        assertEquals(1, CountVertices.countVertices(g, v, 0));
        assertEquals(2, CountVertices.countVertices(g, v, 1));
        assertEquals(2, CountVertices.countVertices(g, v, 2));
    }
}
