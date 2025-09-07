package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFordPrac {

    public static List<List<Integer>>createEdges(int[][]edges){
        List<List<Integer>>result = new ArrayList<>();
        for (int[]edge:edges){
            List<Integer>ans = new ArrayList<>();
            ans.add(edge[0]);
            ans.add(edge[1]);
            ans.add(edge[2]);
            result.add(ans);
        }
        return result;
    }

    public static int [] bellman_ford(int nodes, List<List<Integer>>edges, int src){
        int [] ans = new int[nodes];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[src] = 0;
        for (int i = 0; i < nodes-1; i++) {
            for (List<Integer>edge:edges){
                int u = edge.get(0);
                int v = edge.get(1);
                int wt = edge.get(2);
                if(ans[u] != Integer.MAX_VALUE && ans[u]+wt<ans[v]){
                    ans[v] = ans[u] + wt;
                }
            }
        }

        for (List<Integer>e:edges){
            int u = e.get(0);
            int v = e.get(1);
            int wt = e.get(2);
            if(ans[u] != Integer.MAX_VALUE && ans[u]+wt<ans[v]){
                return new int[]{-1};
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // Graph from the video: 6 vertices (0 to 5)
        int nodes = 6;
        int[][] edgeArray = {
                {0, 3, 7},   // 0 -> 3 (weight 7)
                {0, 1, 12},  // 0 -> 1 (weight 12)
                {3, 4, 2},   // 3 -> 4 (weight 2)
                {3, 2, -9},  // 3 -> 2 (weight -9) - NEGATIVE EDGE
                {1, 2, 3},   // 1 -> 2 (weight 3)
                {4, 5, 1},   // 4 -> 5 (weight 1)
                {2, 5, 5}    // 2 -> 5 (weight 5)
        };

        List<List<Integer>> edges = createEdges(edgeArray);
        System.out.println(edges);
        int src = 0;
        int[] result = bellman_ford(nodes, edges, src);

        if (result.length == 1 && result[0] == -1) {
            System.out.println("Negative cycle detected!");
        } else {
            System.out.println("Shortest distances from vertex " + src + ":");
            for (int i = 0; i < nodes; i++) {
                if (result[i] == Integer.MAX_VALUE) {
                    System.out.println("To vertex " + i + ": INF (unreachable)");
                } else {
                    System.out.println("To vertex " + i + ": " + result[i]);
                }
            }

            System.out.println("\nPaths:");
            System.out.println("0 -> 0: 0");
            System.out.println("0 -> 1: 12 (direct path: 0->1)");
            System.out.println("0 -> 2: -2 (path: 0->3->2, cost: 7+(-9)=-2)");
            System.out.println("0 -> 3: 7 (direct path: 0->3)");
            System.out.println("0 -> 4: 9 (path: 0->3->4, cost: 7+2=9)");
            System.out.println("0 -> 5: 3 (path: 0->3->2->5, cost: 7+(-9)+5=3)");
        }
    }
}