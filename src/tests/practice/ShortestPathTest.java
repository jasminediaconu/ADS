package practice;

import org.junit.jupiter.api.Test;
import practice.Graphs.ShortestPath.GraphImpl;
import practice.Graphs.ShortestPath.ShortestPath;
import practice.Graphs.ShortestPath.Vertex;
import practice.Graphs.ShortestPath.VertexImpl;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShortestPathTest {
    @Test
    public void testDoubleVertex() {
        GraphImpl g = new GraphImpl();
        Vertex v = new VertexImpl(0);
        Vertex w = new VertexImpl(1);
        g.addVertex(v);
        g.addVertex(w);
        g.addEdge(v, w);
        assertEquals(2, ShortestPath.shortestPath(g, v, w).size());
        Vertex[] va = {v, w};
        assertArrayEquals(va, ShortestPath.shortestPath(g, v, w).toArray());
    }

    @Test
    public void testSingleLoopingVertex() {
        GraphImpl g = new GraphImpl();
        Vertex v = new VertexImpl(0);
        g.addVertex(v);
        g.addEdge(v, v);
        assertEquals(1, ShortestPath.shortestPath(g, v, v).size());
    }

    @Test
    public void testMultipleVertex() {
        GraphImpl g = new GraphImpl();
        Vertex a = new VertexImpl(0);
        Vertex b = new VertexImpl(1);
        Vertex c = new VertexImpl(2);
        Vertex d = new VertexImpl(3);
        Vertex e = new VertexImpl(4);
        Vertex f = new VertexImpl(5);
        Vertex h = new VertexImpl(6);

        g.addVertex(a);
        g.addVertex(b);
        g.addVertex(c);
        g.addVertex(d);
        g.addVertex(e);
        g.addVertex(f);
        g.addVertex(h);

        g.addEdge(a, b);
        g.addEdge(b, c);
        g.addEdge(c, f);
        g.addEdge(e, h);
        g.addEdge(f, e);
        g.addEdge(d, e);
        g.addEdge(e, a);
        g.addEdge(a, c);

        assertEquals(3, ShortestPath.shortestPath(g, b, f).size());
        Vertex[] va = {b, c, f};
       // assertArrayEquals(va, ShortestPath.shortestPath(g, b, f).toArray());
    }
}
