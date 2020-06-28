package practice;

import org.junit.jupiter.api.Test;
import practice.TopologicalSort.Graph;
import practice.TopologicalSort.TopologicalSortsDAG;
import practice.TopologicalSort.Vertex;
import practice.TopologicalSorting.TopologicalSorting;

public class TopologicalSortDAGTest {
    @Test
    public void testEmpty() {
        Graph graph = new Graph(6);
        graph.addEdge(0, 3);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(4, 5);
        TopologicalSortsDAG.topologicalSorting(graph, new Vertex(0));
    }

    @Test
    public void testGraph() {
        practice.TopologicalSorting.Graph graph = new practice.TopologicalSorting.Graph(8);
        // A -> C
        graph.addEdge(0, 2);
        // A -> D
        graph.addEdge(0, 3);
        // B -> D
        graph.addEdge(1, 3);
        // B -> F
        graph.addEdge(1, 5);
        // C -> E
        graph.addEdge(2, 4);
        // C -> H
        graph.addEdge(2, 7);
        // C -> D
        graph.addEdge(2, 3);
        // D -> F
        graph.addEdge(3, 5);
        // E -> G
        graph.addEdge(4, 6);
        // F -> G
        graph.addEdge(5, 6);
        // F -> H
        graph.addEdge(5, 7);
        // G -> H
        graph.addEdge(6, 7);

        TopologicalSorting.topologicalSorting(graph);
    }

    @Test
    public void allCombinations() {
        practice.TopologicalSorting.Graph graph = new practice.TopologicalSorting.Graph(8);
        // A -> C
        graph.addEdge(0, 2);
        // A -> D
        graph.addEdge(0, 3);
        // B -> D
        graph.addEdge(1, 3);
        // B -> F
        graph.addEdge(1, 5);
        // C -> E
        graph.addEdge(2, 4);
        // C -> H
        graph.addEdge(2, 7);
        // C -> D
        graph.addEdge(2, 3);
        // D -> F
        graph.addEdge(3, 5);
        // E -> G
        graph.addEdge(4, 6);
        // F -> G
        graph.addEdge(5, 6);
        // F -> H
        graph.addEdge(5, 7);
        // G -> H
        graph.addEdge(6, 7);

        //TopologicalSorting.topological(graph);
    }
}
