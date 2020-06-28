package practice.PathFinding;

import java.util.*;

public class PathFinding {
    public static boolean pathFinding(Graph g, Vertex a, Vertex b) {
        if(g == null || a == null) return false;
        Map predecessors = new HashMap<Vertex, Vertex>();

        GraphIterator iterator = new GraphIterator(g, a);

        // Put all the vertices in the tree map
        while(iterator.hasNext()) {
            Vertex curr = iterator.next();

            if(predecessors.size() == 0) predecessors.put(curr, curr);

            List<Vertex> neighbours = g.getNeighbours(curr);
            for (Vertex n : neighbours) {
                if (!predecessors.containsKey(n)) predecessors.put(n, curr);
            }
        }

        return pathFinding(g, a, b, predecessors);
    }

    public static boolean pathFinding(Graph g, Vertex a, Vertex b, Map<Vertex, Vertex> predecessors) {
        if(a == b) return true;

        if(!predecessors.containsKey(a) || !predecessors.containsKey(b)) return false;

        // Take out the vertex that we want to get to
        Vertex destination = b;

        while(!predecessors.isEmpty()) {

            if(destination == a) return true;

            destination = predecessors.remove(destination);
        }

        return false;

    }
}
