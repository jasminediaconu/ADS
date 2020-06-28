package practice.TopologicalSorting;

import java.util.*;

public class TopologicalSorting {
    /**
     * Given a Graph g, finds one topological sorting.
     * @param g
     * @return
     */
    public static LinkedList<Vertex> topologicalSorting(Graph g) {
        // List of vertices placed in topological order
        LinkedList<Vertex> topological = new LinkedList<>();
        // container of vertices that have no remaining constraints
        Stack<Vertex> ready = new Stack<>();
        // map keeping track of remaining in-degree for each vertex
        Map<Vertex, Integer> inCount = new HashMap<>();

        for (Vertex u : g.getAllVertices()) {
            inCount.put(u, g.inDegree(u));
            // initialize with actual in-degree
            if(inCount.get(u) == 0) ready.push(u);
        }

        while (!ready.isEmpty()) {
            Vertex u = ready.pop();
            topological.addLast(u);
            for(Edge e : g.outgoingEdges(u)) {
                // consider all outgoing neighbors of u
                Vertex v = e.getOutgoingVertex();
                inCount.put(v, inCount.get(v) - 1);

                // v has one less constraint without u
                if (inCount.get(v) == 0) ready.push(v);
            }
        }

        for(Vertex v : topological) System.out.println(v.getId());
        return topological;
    }

//    public static void topological(Graph g) {
//        // Get the number of vertices in g
//        int n = g.getAllVertices().size();
//
//        // array to keep track of the visited vertices
//        boolean[] discovered = new boolean[n];
//
//        // stack to store topological order
//        Stack<Vertex> ready = new Stack<>();
//
//        // map keeping track of remaining in-degree for each vertex
//        Map<Vertex, Integer> inCount = new HashMap<>();
//
//        // All combinations
//        LinkedList<LinkedList<Vertex>> result = new LinkedList();
//
//        // Initialize inCount map with in-degree of each Vertex
//        for (Vertex u : g.getAllVertices()) {
//            inCount.put(u, g.inDegree(u));
//        }
//
//        // initialize array
//        //for(int i = 0; i < n; i++) discovered[i] = false;
//
//        allTopologicalSorting(g, ready, discovered, n, inCount, result);
//
////        // Call helper function now
////        for(int i = 0; i < n; i++) {
////            if(!discovered[i]) allTopologicalSorting(g, ready, discovered, inCount, result);
////        }
////
////        // Print contents of stack
////        while (!ready.isEmpty())
////            System.out.print(ready.pop() + " ");
//
//    }
//
//    public static void allTopologicalSorting(Graph g, Stack<Vertex> path, boolean[] discovered, int n, Map<Vertex, Integer> inCount, LinkedList<LinkedList<Vertex>> result) {
//
//        for(int i = 0; i < n; i++) {
//            Vertex v = g.getVertex(i);
//            if(g.inDegree(v) == 0 && !discovered[i]) {
//                for(Edge e : g.outgoingEdges(v)) {
//                    Vertex u = e.getOutgoingVertex();
//                    inCount.put(u, inCount.get(u) - 1);
//                }
//                // include current node in the path and mark it as discovered
//                path.add(v);
//                discovered[i] = true;
//
//                // recursively
//                allTopologicalSorting(g, path, discovered, n, inCount, result);
//
//                // backtrack: reset in-degree information for the current node
//                for(Edge e : g.outgoingEdges(v)) {
//                    Vertex u = e.getOutgoingVertex();
//                    inCount.put(u, inCount.get(u) + 1);
//                }
//
//                // backtrack: remove current node from the path and
//                // mark it as undiscovered
//                path.pop();
//                discovered[i] = false;
//            }
//        }
//
//        if(path.size() == n) {
//            System.out.println(path);
////            path.forEach(vertex -> System.out.println(vertex.getId()));
////            LinkedList<Vertex> res = new LinkedList<>();
////            for(Vertex v : path) res.add(v);
////            System.out.println("List: ");
////            res.forEach(vertex -> System.out.println(vertex));
////            result.add(res);
//        }
//
//    }

}
