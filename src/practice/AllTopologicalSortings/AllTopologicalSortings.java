package practice.AllTopologicalSortings;

import java.util.*;

// data structure to store graph edges
class Edge
{
    int source, dest;

    public Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
    }
}

// class to represent a graph object
class Graph {
    // A List of Lists to represent an adjacency list
    List<List<Integer>> adjList = null;

    // stores in-degree of a vertex
    List<Integer> indegree = null;

    // Constructor
    Graph(List<Edge> edges, int N) {
        adjList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }

        // initialize in-degree of each vertex by 0
        indegree = new ArrayList<>(Collections.nCopies(N, 0));

        // add edges to the undirected graph
        for (Edge edge: edges) {
            int src = edge.source;
            int dest = edge.dest;

            // add an edge from source to destination
            adjList.get(src).add(dest);

            // increment in-degree of destination vertex by 1
            indegree.set(dest, indegree.get(dest) + 1);
        }
    }
}

class Main
{
    // Recursive function to find all topological orderings of a given DAG
    public static void findAllTopologicalOrders(Graph graph, Stack<Integer> path,
                                                boolean[] discovered, int N)
    {
        // do for every vertex
        for (int v = 0; v < N; v++)
        {
            // proceed only if in-degree of current node is 0 and
            // current node is not processed yet
            if (graph.indegree.get(v) == 0 && !discovered[v])
            {
                // for every adjacent vertex u of v, reduce in-degree of u by 1
                for (int u: graph.adjList.get(v)) {
                    graph.indegree.set(u, graph.indegree.get(u) - 1);
                }

                // include current node in the path and mark it as discovered
                path.add(v);
                discovered[v] = true;

                // recurse
                findAllTopologicalOrders(graph, path, discovered, N);

                // backtrack: reset in-degree information for the current node
                for (int u: graph.adjList.get(v)) {
                    graph.indegree.set(u, graph.indegree.get(u) + 1);
                }

                // backtrack: remove current node from the path and
                // mark it as undiscovered
                path.pop();
                discovered[v] = false;
            }
        }

        // print the topological order if all vertices are included in the path
        if (path.size() == N) {
            System.out.println(path);
        }
    }

    // Print all topological orderings of a given DAG
    public static void printAllTopologicalOrders(Graph graph)
    {
        // get number of nodes in the graph
        int N = graph.adjList.size();

        // create an auxiliary array to keep track of whether vertex is discovered
        boolean[] discovered = new boolean[N];

        // list to store the topological order
        Stack<Integer> path = new Stack<>();

        // find all topological ordering and print them
        findAllTopologicalOrders(graph, path, discovered, N);
    }

    public static void main(String[] args)
    {
        // List of graph edges as per above diagram
        List<Edge> edges = Arrays.asList(
                new Edge(0, 6), new Edge(1, 2),
                new Edge(1, 4), new Edge(1, 6),
                new Edge(3, 0), new Edge(3, 4),
                new Edge(5, 1), new Edge(7, 0),
                new Edge(7, 1)
        );

        // Number of nodes in the graph
        int N = 8;

        // create a graph from edges
        Graph graph = new Graph(edges, N);

        // print all topological ordering of the graph
        printAllTopologicalOrders(graph);
    }
}