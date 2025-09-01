import java.util.*;

public class GraphConnectivity {

    static ArrayList<ArrayList<Integer>> buildGraph(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }

    static boolean canReach(ArrayList<ArrayList<Integer>> graph, int n, int src, int dest) {
        if (src == dest) return true;

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited[src] = true;

        while (!queue.isEmpty()) {
            int current = queue.remove();
            for (int neighbor : graph.get(current)) {
                if (neighbor == dest) return true;
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{0,3}, {0,1}, {1,2}, {2,3}, {4,5}, {4,6}, {5,6}};

        ArrayList<ArrayList<Integer>> graph = buildGraph(n, edges);

        System.out.println(canReach(graph, n, 0, 3));  // true
        System.out.println(canReach(graph, n, 0, 4));  // false
        System.out.println(canReach(graph, n, 4, 6));  // true
        System.out.println(canReach(graph, n, 1, 5));  // false
    }
}