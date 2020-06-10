//package practice.Graphs;
//
//import practice.Kruskal.Graph;
//
//import java.util.Map;
//import java.util.Stack;
//
//public class DirectedAcyclicGraph {
//    public static int PositionalList<Vertex> topologicalSort(Graph g) {
//        // list of vertices placed in topological order
//        PositionalList<Vertex> topo = new LinkedPositionalList<>();
//        // container of vertices that have no remaining constraints
//        Stack<Vertex> ready = new LinkedStack<>();
//        // map keeping track of remaining in-degree for each vertex
//        Map<Vertex, Integer> inCount = new ProbeHashMap<>();
//        for (Vertex u : g.vertices()) {
//            inCount.put(u, g.inDegree(u));
//            // initialize with actual in-degree
//            if (inCount.get(u) == 0)
//                // if u has no incoming edges,
//                ready.push(u);
//            // it is free of constraints
//            }
//        while (!ready.isEmpty()) {
//            Vertex u = ready.pop();
//            topo.addLast(u);
//            for(Edge e : g.outgoingEdges(u)) {
//                // consider all outgoing neighbors of u
//                Vertex v = g.opposite(u, e);
//                inCount.put(v, inCount.get(v) - 1);
//                // v has one less constraint without u
//                if (inCount.get(v) == 0)
//                    ready.push(v);
//            }
//        }
//        return topo;
//    }
//}
