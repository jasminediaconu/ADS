package practice.Graphs.ShortestPath;

import java.util.*;

public class ShortestPath {
    /**
     * Find the shortest path between v and u in the graph g.
     *
     * @param g
     *     graph to search in.
     * @param v
     *     node to start from.
     * @param u
     *     node to reach.
     * @return the nodes you that form the shortest path, including v and u. An
     * empty list iff there is no path between v and u.
     */
    public static List<Vertex> shortestPath(Graph g, Vertex v, Vertex u) {
        List<Vertex> result = new ArrayList<>();
        if(g == null || v == null) return result;

        Map<Vertex, Vertex> predecessors = new TreeMap<>();

        GraphIterator iterator = new GraphIterator(g, v);

        // Put all the vertices in the tree map
        while(iterator.hasNext()) {
            Vertex curr = iterator.next();

            if(predecessors.size() == 0) predecessors.put(curr, curr);

            List<Vertex> neighbours = g.getNeighbours(curr);
            for (Vertex n : neighbours) {
                if (!predecessors.containsKey(n)) predecessors.put(n, curr);
            }
        }

        predecessors.forEach((e, l) -> System.out.println(e.toString() + ", value: " + l.toString()));

        if(!predecessors.containsKey(v) || !predecessors.containsKey(u)) return result;

        // Take out the vertex that we want to get to
        Vertex destination = u;

        result.add(destination);

        while(!predecessors.isEmpty()) {

            if(destination == v) break;

            destination = predecessors.remove(destination);

            result.add(destination);
        }

        Collections.reverse(result);

        //result.forEach(e -> System.out.println(e.toString()));

        return result;
    }
}
