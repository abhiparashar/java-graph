package graphs.topologicalsort;

import java.util.*;

public class TopologicalSort {

    public static List<List<Integer>> createGraph(int nodes, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
        }
        return graph;
    }

    // BFS Approach (Kahn's Algorithm) - Your version with cycle detection
    public static List<Integer> topoSortedBFS(int nodes, List<List<Integer>> graph) {
        List<Integer> topo = new ArrayList<>();
        int[] indegree = new int[nodes];
        Queue<Integer> queue = new LinkedList<>();

        // Calculate in-degrees
        for (int i = 0; i < nodes; i++) {
            for (int nbr : graph.get(i)) {
                indegree[nbr]++;
            }
        }

        // Add nodes with in-degree 0
        for (int i = 0; i < nodes; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int rem = queue.poll();
            topo.add(rem);
            for (int nbr : graph.get(rem)) {
                indegree[nbr]--;
                if (indegree[nbr] == 0) {
                    queue.add(nbr);
                }
            }
        }

        // Cycle detection
        if (topo.size() != nodes) {
            return new ArrayList<>(); // Cycle detected
        }
        return topo;
    }

    // DFS Approach with 3-state tracking
    public static List<Integer> topoSortedDFS(int nodes, List<List<Integer>> graph) {
        int[] state = new int[nodes]; // 0: unvisited, 1: visiting, 2: visited
        Stack<Integer> stack = new Stack<>();

        // Visit all nodes
        for (int i = 0; i < nodes; i++) {
            if (state[i] == 0) {
                if (hasCycleDFS(graph, i, state, stack)) {
                    return new ArrayList<>(); // Cycle detected
                }
            }
        }

        // Convert stack to list (reverse order)
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    private static boolean hasCycleDFS(List<List<Integer>> graph, int node, int[] state, Stack<Integer> stack) {
        if (state[node] == 1) return true;  // Back edge - cycle
        if (state[node] == 2) return false; // Already processed

        state[node] = 1; // Mark as visiting

        for (int neighbor : graph.get(node)) {
            if (hasCycleDFS(graph, neighbor, state, stack)) {
                return true;
            }
        }

        state[node] = 2; // Mark as visited
        stack.push(node); // Add to result (post-order)
        return false;
    }

    public static void main(String[] args) {
        // Test case 1: Valid DAG
        int nodes = 4;
        int[][] edges = {{1,0}, {2,0}, {3,1}, {3,2}};
        List<List<Integer>> graph = createGraph(nodes, edges);

        System.out.println("BFS Topo Sort: " + topoSortedBFS(nodes, graph));
        System.out.println("DFS Topo Sort: " + topoSortedDFS(nodes, graph));

        // Test case 2: Cycle detection
        int[][] cyclicEdges = {{0,1}, {1,2}, {2,0}};
        List<List<Integer>> cyclicGraph = createGraph(3, cyclicEdges);

        System.out.println("BFS with cycle: " + topoSortedBFS(3, cyclicGraph));
        System.out.println("DFS with cycle: " + topoSortedDFS(3, cyclicGraph));
    }
}