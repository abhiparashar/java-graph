package graphs.djikstra;

import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class CheapestFlights {
    // Modified Pair class with 3 fields: node, cost, stops
    public static class Pair implements Comparable<Pair>{
        int node, cost, stops;

        Pair(int node, int cost, int stops){
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }

        @Override
        public int compareTo(@NotNull Pair o) {
            return this.cost - o.cost;  // Min-heap based on cost
        }
    }

    public static List<List<List<Integer>>> createGraph(int n, int[][] flights){
        List<List<List<Integer>>> graph = new ArrayList<>();

        // Create n size for 0-indexed nodes
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build directed graph
        for (int[] flight : flights){
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            graph.get(from).add(new ArrayList<>(Arrays.asList(to, price)));
        }

        return graph;
    }

    public static int findCheapestPrice(List<List<List<Integer>>> graph, int n, int src, int dst, int k){
        // We use a different approach - no visited array since we can revisit nodes
        // with different stop counts

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0, 0));  // Start at src with cost=0, stops=0

        // Optional: Track best cost to reach each node with specific stop count
        // This optimization can prevent some redundant processing
        int[][] minCost = new int[n][k + 2];  // [node][stops]
        for (int i = 0; i < n; i++) {
            Arrays.fill(minCost[i], Integer.MAX_VALUE);
        }

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            int cost = current.cost;
            int stops = current.stops;

            // If we reached destination, return cost (PQ ensures this is minimum)
            if (node == dst) {
                return cost;
            }

            // If we've used all allowed stops, skip
            if (stops > k) {
                continue;
            }

            // Optimization: if we've seen a better cost for this (node, stops), skip
            if (cost > minCost[node][stops]) {
                continue;
            }
            minCost[node][stops] = cost;

            // Explore neighbors
            for (List<Integer> neighbor : graph.get(node)) {
                int nextNode = neighbor.get(0);
                int price = neighbor.get(1);
                int newCost = cost + price;
                int newStops = stops + 1;

                // Add to queue if we haven't exceeded stop limit
                if (newStops <= k + 1) {  // k+1 because we count intermediate stops
                    pq.add(new Pair(nextNode, newCost, newStops));
                }
            }
        }

        return -1;  // No path found within k stops
    }

    public static void main(String[] args) {
        // Test case 1
        int[][] flights1 = {{0,1,100},{1,2,100},{0,2,500}};
        int n1 = 3, src1 = 0, dst1 = 2, k1 = 1;
        List<List<List<Integer>>> graph1 = createGraph(n1, flights1);
        System.out.println("Test 1: " + findCheapestPrice(graph1, n1, src1, dst1, k1)); // Expected: 200

        // Test case 2
        int[][] flights2 = {{0,1,100},{1,2,100},{0,2,500}};
        int n2 = 3, src2 = 0, dst2 = 2, k2 = 0;
        List<List<List<Integer>>> graph2 = createGraph(n2, flights2);
        System.out.println("Test 2: " + findCheapestPrice(graph2, n2, src2, dst2, k2)); // Expected: 500

        // Test case 3
        int[][] flights3 = {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
        int n3 = 4, src3 = 0, dst3 = 3, k3 = 1;
        List<List<List<Integer>>> graph3 = createGraph(n3, flights3);
        System.out.println("Test 3: " + findCheapestPrice(graph3, n3, src3, dst3, k3)); // Expected: 6
    }
}