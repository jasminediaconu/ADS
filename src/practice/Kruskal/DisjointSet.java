package practice.Kruskal;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DisjointSet {
    Map<Vertex, Vertex> parent;

    /**
     * Constructor, creates a new Set for each Vertex
     *
     * @param list
     */
    public DisjointSet(Collection<Vertex> list) {
        parent = new HashMap<>();
        // Create n disjoint sets, one for each vertex
        for (Vertex v : list)
            parent.put(v, v);
    }

    public Vertex find(Vertex v) {
        // Vertex is the root
        if (parent.get(v) == v) return v;

        // recursive call
        return find(parent.get(v));
    }

    public void union(Vertex a, Vertex b) {
        Vertex x = find(a);
        Vertex y = find(b);

        parent.put(x, y);
    }
}
