package practice.Graph;

import java.util.Collection;
import java.util.List;

public interface Graph {
    /**
     * Returns the neighbours in a sorted collection by id
     *
     * @param v node to get the neighbours of.
     * @return sorted collection of neighbours.
     */
    List<Vertex> getNeighbours(Vertex v);

    /**
     * @return an unsorted collection of all vertices in the graph.
     */
    Collection<Vertex> getAllVertices();
}
