package exam;

import exam.Dijkstra.DijkstraShortestPath;
import exam.Dijkstra.Graph;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DijkstraTest {
    /**
     * Tests the following graph with all edges having weight 1
     * 1 - 0 - 3
     * |   |
     * 2 - 4
     */
    @Test
    public void testUnweighted() {
        Graph g = new Graph(5);
        g.addEdge(0, 1, 1);
        g.addEdge(0, 2, 1);
        g.addEdge(2, 4, 1);
        g.addEdge(0, 3, 1);
        g.addEdge(3, 4, 1);
        // Path from 0 to 4 should be 2
//        assertEquals(1, DijkstraShortestPath.shortestPath(g, g.getVertex(0), g.getVertex(1)));
        // Path from 1 to 2 should be 2
        assertEquals(2, DijkstraShortestPath.shortestPath(g, g.getVertex(1), g.getVertex(2)));
        // Path from 3 to 4 should be 1
        assertEquals(1, DijkstraShortestPath.shortestPath(g, g.getVertex(3), g.getVertex(4)));
        // Path from 3 to 1 should be 2
        assertEquals(2, DijkstraShortestPath.shortestPath(g, g.getVertex(3), g.getVertex(1)));
    }

    /**
     * Tests the following graph:
     * 0 - 1 - 3
     * |    \  |
     * |     \ |
     * 2  ---  4
     * <p>
     * The weights are as follows:
     * 0 - 1: 1
     * 1 - 3: 6
     * 3 - 4: 4
     * 1 - 4: 1
     * 0 - 2: 7
     * 2 - 4: 4
     */
    @Test
    public void testWeighted() {
        Graph g = new Graph(5);
        g.addEdge(0, 1, 1);
        g.addEdge(1, 3, 6);
        g.addEdge(3, 4, 4);
        g.addEdge(1, 4, 1);
        g.addEdge(0, 2, 7);
        g.addEdge(2, 4, 4);
        // Path is 0-1-4
        assertEquals(2, DijkstraShortestPath.shortestPath(g, g.getVertex(0), g.getVertex(4)));
        // Path is 0-1-4-3
        assertEquals(6, DijkstraShortestPath.shortestPath(g, g.getVertex(0), g.getVertex(3)));
        // Path is 2-4
        assertEquals(4, DijkstraShortestPath.shortestPath(g, g.getVertex(2), g.getVertex(4)));
        // Path is 2-4-1-0
        assertEquals(6, DijkstraShortestPath.shortestPath(g, g.getVertex(2), g.getVertex(0)));
    }
}
