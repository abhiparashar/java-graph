import java.util.*;

public class BFSTraversal {

    // Method to construct adjacency list from edges
    public static List<List<Integer>> constructGraph(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
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

    // Method to perform BFS traversal
    public static void BFS(List<List<Integer>> graph, int startNode) {
        int n = graph.size();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.add(startNode);
        visited[startNode] = true;

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {
            int current = queue.remove();
            System.out.print(current + " ");

            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {
                {0, 1}, {0, 3}, {1, 2}, {2, 3},
                {3, 4}, {4, 5}, {4, 6}, {5, 6}
        };

        // Step 1: Construct the graph
        List<List<Integer>> graph = constructGraph(n, edges);

        // Step 2: Perform BFS traversal
        BFS(graph, 0);
    }
}