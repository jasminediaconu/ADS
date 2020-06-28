package practice.TopologicalSort;
import java.util.*;

public class TopologicalSortsDAG {
//
//    public static void allTopologicalSorts(Graph g) {
//        if(g == null || g.size < 1) return;
//
//        boolean[] visited = new boolean[g.size()];
//
//        int[] indegree = new int[g.size()];
//
//        for (int i = 0; i < g.size(); i++) {
//            for (int var : g.getList(i)) {
//                indegree[var]++;
//            }
//        }
//
//        ArrayList<Integer> stack = new ArrayList<>();
//
//        findTopologicalSorts(g, visited, indegree, stack, 0);
//    }
//
//    private static void findTopologicalSorts(Graph g, boolean[] visited,
//                                             int[] indegree, ArrayList<Integer> stack, int count) {
//        // To indicate whether all topological are found
//        // or not
//        boolean flag = false;
//        for (int i = 0; i < indegree.length; i++) {
//            // If indegree is 0 and not yet visited then
//            // only choose that vertex
//            if (!visited[i] && indegree[i] == 0) {
//
//                // including in result
//                visited[i] = true;
//                stack.add(i);
//                for (int adjacent : g.getList(i)) {
//                    indegree[adjacent]--;
//                }
//
//                findTopologicalSorts(g, visited, indegree, stack, count+1);
//
//                // resetting visited, res and indegree for
//                // backtracking
//                visited[i] = false;
//                stack.remove(stack.size() - 1);
//                for (int adjacent : g.getList(i)) {
//                    indegree[adjacent]++;
//                }
//
//                flag = true;
//            }
//        }
//        // We reach here if all vertices are visited.
//        // So we print the solution here
//        if (!flag) {
//            for(Integer element : stack) {
//                System.out.print(element + " ");
//            }
//            System.out.println();
//        }
//    }

    /**
     * Topological sorting.
     * @param g
     * @param u
     */
    public static List<Vertex> topologicalSorting(Graph g, Vertex u) {
        if(g == null || u == null) return new LinkedList<>();

        return topologicalSorting(g, u, new HashSet<Vertex>(), new LinkedList<Vertex>());
    }

    public static List<Vertex> topologicalSorting(Graph g, Vertex u, Set<Vertex> known, LinkedList<Vertex> result) {
        LinkedList<Vertex> vertices = new LinkedList<>();

        for(Vertex v : g.getAllVertices())
            vertices.add(v);

        while(!vertices.isEmpty()) {
            vertices.remove(u);
            if(!known.contains(u))
                dfs(g, u, known);

            if(vertices.isEmpty()) break;

            u = vertices.getFirst();
        }

        for(Vertex v : known)
            result.addLast(v);

        for(Vertex v : result)
            System.out.println(v);

        return result;
    }

    public static void dfs(Graph g, Vertex v, Set<Vertex> known) {
        Stack<Vertex> dfs = new Stack<>();
        dfs.push(v);

        while (!dfs.isEmpty()) {
            Vertex v1 = dfs.pop();
            known.add(v1);

            for (Vertex v2 : v1.getNeighbours()) {
                if (!known.contains(v2))
                    dfs.push(v2);
            }
        }

    }
}
