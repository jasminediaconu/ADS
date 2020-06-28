package practice;

import org.junit.jupiter.api.Test;
import practice.PathFinding.GraphImpl;
import practice.PathFinding.PathFinding;
import practice.PathFinding.Vertex;
import practice.PathFinding.VertexImpl;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PathFindingTest {
    @Test
    public void testDoubleVertex() {
        GraphImpl g = new GraphImpl();
        Vertex v = new VertexImpl(0);
        Vertex w = new VertexImpl(1);
        g.addVertex(v);
        g.addVertex(w);
        g.addEdge(v, w);
        assertEquals(true, PathFinding.pathFinding(g, v, w));
    }

    @Test
    public void testSingleLoopingVertex() {
        GraphImpl g = new GraphImpl();
        Vertex v = new VertexImpl(0);
        g.addVertex(v);
        g.addEdge(v, v);
        assertEquals(true, PathFinding.pathFinding(g, v, v));
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
        //g.addEdge(b, c);
        //g.addEdge(c, f);
        g.addEdge(e, h);
        g.addEdge(f, e);
        g.addEdge(d, e);
        g.addEdge(e, a);
        //g.addEdge(a, c);

        assertEquals(false, PathFinding.pathFinding(g, b, c));

        assertEquals(false, PathFinding.pathFinding(g, a, c));
    }
}
